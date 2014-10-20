package fr.unice.polytech.soa1.employeeRPC;



import fr.unice.polytech.soa1.business.DataAccessObject;
import fr.unice.polytech.soa1.business.Item;
import fr.unice.polytech.soa1.business.Task;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by user on 04/10/14.
 */
@Stateless(name = "employee-private")
@WebService(targetNamespace = "http://informatique.polytech.unice.fr/soa1/employeeRPC/private",
        portName = "EmployeeRPCPrivatePort",
        serviceName = "EmployeeRPCPrivateService",
        endpointInterface = "fr.unice.polytech.soa1.employeeRPC.EmployeeRPC")
public class EmployeeRPCImpl implements EmployeeRPC {

    @EJB
    private DataAccessObject dao;

    @Override
    public String getTask(String id) throws UnknownContentFault, UnknownTaskFault {
        Optional<Task> tasks = dao.getEmployeeTask(id);

        if(!tasks.isPresent()){
            throw new UnknownTaskFault(id);
        }
        return tasks.get().getDayLogEvent()+"";
    }

    @Override
    public List<String> placeProduct(String productRef, int width, int height, int depth, int quantity) {
        ArrayList<String> position = new ArrayList();
        //algo to find a position by taking into account the item dimensions

        position.add("floor 1");
        position.add("corridor 2");
        position.add("rack 35");
        return position;
    }

    @Override
    public List<String> getProductLocation(String productRef) throws UnknownProductReference {
        ArrayList<String> position = new ArrayList();
        Optional<Item> product = dao.findItemByReference(productRef);

        if(!product.isPresent()){
            throw  new UnknownProductReference(productRef);
        }

        position.add("" + product.get().getFloor());
        position.add("" + product.get().getCorridor());
        position.add("" + product.get().getRack());
        return position;
    }


}
