package fr.unice.polytech.soa1.teamLeaderREST;

import fr.unice.polytech.soa1.business.DayLog;
import fr.unice.polytech.soa1.business.Employee;
import fr.unice.polytech.soa1.business.Task;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 04/10/14.
 */
@Produces({"application/xml"})
public interface TeamLeaderREST {
    @Path("/dayLogs")
    @GET
    public Response dayLogs();

    @Path("/tasks")
    @GET
    public Response tasks();

    @Path("/employees")
    @GET
    public Response employees();

    @Path("/{id}/tasks")
    @POST
    public Response assignEmployeeToTask(@QueryParam("employeeId")String employeesId, @PathParam("id") String taskId);

    @Path("/{id}/createTask")
    @POST
    public Response createTask( @PathParam("id")String taskId, @QueryParam("eventId") String eventId);

}

@XmlRootElement(name = "tasks")
class ListOfTasks {
    private List<Task> tasks;
    @XmlElement(name = "day_log")
    public List<Task> getTasks() { return tasks; }
    public void setTasks(List<Task> tasks) { this.tasks = tasks; }

    public ListOfTasks() { this.tasks = new ArrayList<>(); }
}

@XmlRootElement(name = "day_logs")
class ListOfDayLogs {
    private List<DayLog> dayLogs;
    @XmlElement(name = "day_log")
    public List<DayLog> getDayLogs() { return dayLogs; }
    public void setDayLogs(List<DayLog> dayLogs) { this.dayLogs = dayLogs; }

    public ListOfDayLogs() { this.dayLogs = new ArrayList<>(); }
}

@XmlRootElement(name = "employees")
class ListOfEmployees {
    private List<Employee> employees;

    ListOfEmployees() {
        this.employees = new ArrayList<>();;
    }

    @XmlElement(name = "employees")
    public List<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }



}



@XmlRootElement(name = "unknown_resource")
class UnknownResource {
    private String type;
    private String key;

    public UnknownResource() {}

    public UnknownResource(String type, String key) {
        this.type = type;
        this.key = key;
    }

    @XmlElement(name = "kind")
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @XmlElement(name = "key")
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}