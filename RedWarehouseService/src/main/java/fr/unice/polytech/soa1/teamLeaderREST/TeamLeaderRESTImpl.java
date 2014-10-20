package fr.unice.polytech.soa1.teamLeaderREST;

import fr.unice.polytech.soa1.business.DataAccessObject;
import fr.unice.polytech.soa1.business.DayLog;
import fr.unice.polytech.soa1.business.Employee;
import fr.unice.polytech.soa1.business.Task;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by user on 04/10/14.
 */
@Path("/teamLeaderREST/private")
public class TeamLeaderRESTImpl implements TeamLeaderREST {
    @EJB
    private DataAccessObject dao;

    @Override
    public Response dayLogs() {
        ListOfDayLogs listOfDayLogs = new ListOfDayLogs();
        listOfDayLogs.setDayLogs( dao.getDayLogs());
        return Response.ok(listOfDayLogs).build();
    }

    @Override
    public Response tasks() {
        ListOfTasks listOfTasks = new ListOfTasks();
        listOfTasks.setTasks(dao.getTaskAssigned());
        return Response.ok(listOfTasks).build();
    }

    @Override
    public Response employees() {
        ListOfEmployees listOfEmployees = new ListOfEmployees();
        listOfEmployees.setEmployees(dao.getEmployees());
        return Response.ok(listOfEmployees).build();
    }

    @Override
    public Response assignEmployeeToTask(String employeesId, String taskId) {
        Optional<Task> taskOptional = dao.findTaskById(taskId);
        if(!taskOptional.isPresent()){
            UnknownResource error = new UnknownResource("task", ""+ taskId);
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }

        Optional<Employee> employeeOptional = dao.findEmployeeById(employeesId);

        if(!employeeOptional.isPresent()){
            UnknownResource error = new UnknownResource("employee", ""+ employeesId);
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }


        taskOptional.get().addEmployee(employeesId);
        Task t = taskOptional.get();
        dao.getTaskAssigned().add(t);
        return Response.ok(t).build();
    }

    @Override
    public Response createTask(String taskId, String eventId) {
        Optional<DayLog> dayLogById = dao.findDayLogById(eventId);

        if(!dayLogById.isPresent()){
            UnknownResource error = new UnknownResource("dayLog", ""+eventId);
            return Response.status(Response.Status.NOT_FOUND).entity(error).build();
        }


        Task task = new Task(taskId,eventId);
        dao.getTaskAssigned().add(task);

        return Response.ok(task).build();
    }



}


