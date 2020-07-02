package net.shippingapp.portcallops.dischargelistingest.command;

import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.utils.UUIDs;

import net.shippingapp.portcallops.dischargelistingest.commandframework.CommandException;
import net.shippingapp.portcallops.dischargelistingest.utils.CassandraDataSource;
import net.shippingapp.portcallops.dischargelistingest.xmlentity.DischargeListDocument;
import net.shippingapp.portcallops.dischargelistingest.xmlentity.DischargeListLine;
import net.shippingapp.portcallops.dischargelistingest.xmlentity.DischargeListShipment;
import net.shippingapp.portcallops.dischargelistingest.xmlentity.Equipment;

public class PersistDischargeListDataCommand extends BaseCommand {

    public void execute() throws CommandException {

        try {

            DischargeListDocument dischargeReport = (DischargeListDocument) this.getQueueContext()
                    .getFromContext(ContextConstants.DISCHARGE_LIST_XML_TO_OBJECT_KEY);

            Session cqlSession = CassandraDataSource.getInstance().getCQLSession();

            String portCode = dischargeReport.getDischargeListData().getTerminalID();
            String vesselCode = dischargeReport.getDischargeListData().getPreCarrier().getVesselVoyage()
                    .getVesselCode();
            String voyageCode = dischargeReport.getDischargeListData().getPreCarrier().getVesselVoyage()
                    .getVoyageCode();
            UUID dischargeListID = UUIDs.random();
            UUID dischargeListVersionID = UUIDs.random();
            String previousPortCode = dischargeReport.getDischargeListData().getPreviousPortCode();
            String nextPortCode = dischargeReport.getDischargeListData().getNextPortCode();

            final PreparedStatement cargoDischargeListPreparedStmt = cqlSession
                    .prepare("INSERT into cargo_handling_list_cockpit.discharge_list_by_port_vessel_voyage "
                            + "(port_code, port_name, vessel_code, vessel_name, voyage_code, next_port_code, previous_port_code, discharge_list_id , discharge_list_desc , discharge_list_version_id, discharge_list_version_timestamp, discharge_list_status) "
                            + " values(?,? , ?,?,?, ?, ?,?,?,?,?,?)");

            BoundStatement cargoDischargeListBoundStmt = cargoDischargeListPreparedStmt.bind()
                    .setString("port_code", portCode)
                    .setString("port_name", "")
                    .setString("vessel_code", vesselCode)
                    .setString("vessel_name", "")
                    .setString("voyage_code", voyageCode)
                    .setUUID("discharge_list_id", dischargeListID)
                    .setString("discharge_list_desc", "discharge list description")
                    .setUUID("discharge_list_version_id", dischargeListVersionID)
                    .setUUID("discharge_list_version_timestamp", UUIDs.timeBased())
                    .setString("discharge_list_status", "Provisional")
                    .setString("previous_port_code", previousPortCode)
                    .setString("next_port_code", nextPortCode);

            cqlSession.execute(cargoDischargeListBoundStmt);

            // Insert into discharge_list_containers_by_port_vessel_voyage
            final PreparedStatement containerDischargeListPreparedStmt = cqlSession
                    .prepare("INSERT into cargo_handling_list_cockpit.discharge_list_containers_by_port_vessel_voyage "
                            + "(port_code, vessel_code,  voyage_code, discharge_list_id ,  discharge_list_version_id, "
                            + "shipping_number, container_number, discharge_list_container_id, container_commodity_desc, container_operator,container_type, container_iso_code, container_size, container_weight_kg) "
                            + " values(?,? , ?, ?, ?,?,?,?,?,?,?,?,?,?)");

            // container details
            int numberOfShipments = dischargeReport.getDischargeListData().getDischargeListShipments().size();

            for (int i = 0; i < numberOfShipments; i++) {

                DischargeListShipment shipment = (DischargeListShipment) dischargeReport.getDischargeListData()
                        .getDischargeListShipments().get(i);
                String bookingNumber = shipment.getBookingNumber();
                int numberOfContainers = shipment.getDischargeListLines().size();

                for (int j = 0; j < numberOfContainers; j++) {

                    DischargeListLine dll = (DischargeListLine) shipment.getDischargeListLines().get(j);
                    Equipment equipment = dll.getContainerDetails().getEquipment();
                    String equipmentNumber = equipment.getEquipmentNumber();
                    String equipmentIsoCode = equipment.getEquipmentISOCode() ;
                    String equipmentSize    = equipment.getEquipmentSize() ;
                    String equipmentType    = equipment.getEquipmentType() ;
                    UUID   equipmentId      = UUIDs.random() ;
                    String operator = dll.getContainerDetails().getOperator() ;

                    BoundStatement containerDischargeListBoundStmt = containerDischargeListPreparedStmt.bind()
                    .setString("port_code", portCode)
                    .setString("vessel_code", vesselCode)
                    .setString("voyage_code", voyageCode)
                    .setUUID("discharge_list_id", dischargeListID)
                    .setUUID("discharge_list_version_id", dischargeListVersionID)
                    .setUUID("discharge_list_container_id", equipmentId)
                    .setString("shipping_number", bookingNumber)
                    .setString("container_number", equipmentNumber) 
                    .setString("container_commodity_desc", "")
                    .setString("container_operator", operator)
                    .setString("container_type", equipmentType)
                    .setString("container_iso_code", equipmentIsoCode)
                    .setString("container_size", equipmentSize)
                    .setInt("container_weight_kg", 2000) ;

                    cqlSession.execute(containerDischargeListBoundStmt);


                }

            }

        } catch (Exception e) {

            e.printStackTrace();
            throw new CommandException(e);
        }

    }

}