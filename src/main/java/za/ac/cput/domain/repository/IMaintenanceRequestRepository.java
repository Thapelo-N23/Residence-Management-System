package za.ac.cput.domain.repository;

import za.ac.cput.domain.entities.MaintenanceRequest;

import java.util.List;
import java.util.Set;

public interface IMaintenanceRequestRepository {

    MaintenanceRequest create(MaintenanceRequest request);

    MaintenanceRequest read(String s);

    MaintenanceRequest update(MaintenanceRequest request);

    boolean delete(String id);

    List<MaintenanceRequest> getAll();
}
