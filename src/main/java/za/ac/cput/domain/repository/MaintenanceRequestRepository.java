package za.ac.cput.domain.repository;

import za.ac.cput.domain.entities.MaintenanceRequest;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceRequestRepository implements IMaintenanceRequestRepository{
    private static IMaintenanceRequestRepository repository = null;
    private List<MaintenanceRequest> MaintenanceRequestList;

    private MaintenanceRequestRepository() {
        MaintenanceRequestList = new ArrayList<MaintenanceRequest>();

    }

    public static MaintenanceRequestRepository getRepository() {
        if (repository == null) {
            repository = new MaintenanceRequestRepository();
        }
        return (MaintenanceRequestRepository) repository;
    }

    @Override
    public MaintenanceRequest create(MaintenanceRequest request) {
        boolean success = request.add(request);
        if (success) {
            return request;
        }
        return null;
    }

    @Override
    public MaintenanceRequest read(String s) {
        for (MaintenanceRequest request : MaintenanceRequestList) {

            if (request.getRequestID().equals(request.getRequestID())) {
                return request;
            }
        }
        return null;
    }

    @Override
    public MaintenanceRequest update(MaintenanceRequest request) {
        String id = request.getRequestID();
        MaintenanceRequest requestID = read(id);
        if (requestID == null)
            return null;

        return requestID;
    }

    @Override
    public boolean delete(String id) {
        MaintenanceRequest requestToDelete = read(id);
        if(requestToDelete==null)
            return false;
        return false;
    }

    @Override
    public List<MaintenanceRequest> getAll() {
        return MaintenanceRequestList;
    }
}
