/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.threads;

import communication.Operations;

import communication.Request;
import communication.Response;
import communication.ResponseType;

import controller.ServerController;
import domain.ApartmentFeatures;
import domain.Employee;
import domain.FeatureValue;
import domain.Listing;
import domain.Location;
import domain.Rental;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Andrej
 */
public class HandleClientThread extends Thread {

    private final Socket socket;

    public HandleClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request request = (Request) in.readObject();
                Response response = handleRequest(request);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Response handleRequest(Request request) throws Exception {
        switch (request.getOperation()) {
            case Operations.LOGIN:
                return login(request);
            case Operations.ADD_EMPLOYEE:
                return addEmployee(request);
            case Operations.GET_EMPLOYEES:
                return getAllEmployees(request);
            case Operations.DELETE_EMPLOYEE:
                return deleteEmployee(request);
            case Operations.UPDATE_EMPLOYEE:
                return updateEmployee(request);
            case Operations.GET_LOCATIONS:
                return getAllLocations(request);
            case Operations.GET_APARTMENT_FEATURES:
                return getAllApartmentFeatures(request);
            case Operations.ADD_LISTING:
                return addListing(request);
            case Operations.GET_ALL_LISTINGS:
                return getAllListings(request);
            case Operations.UPDATE_LISTING:
                return updateListing(request);
            case Operations.DELETE_LISTING:
                return deleteListing(request);
            case Operations.ADD_RENTAL:
                return addRental(request);
            case Operations.GET_ALL_RENTALS:
                return getAllRentals(request);
            case Operations.GET_ALL_FEATURE_VALUES:
                return getAllFeatureValues(request);
        }
        return null;
    }

    public Socket getSocket() {
        return socket;
    }

    private Response login(Request request) {
        Response response = new Response();
        Employee requestEmployee = (Employee) request.getArgument();
        try {

            Employee employee = ServerController.getInstance().login(requestEmployee);
            if (employee != null) {
                System.out.println("Successful login!");
                response.setResponseType(ResponseType.SUCCESS);
                response.setResult(employee);
            } else {
                throw new Exception("Credentials don't match any employees!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response addEmployee(Request request) {
        Response response = new Response();
        Employee employee = (Employee) request.getArgument();
        try {
            ServerController.getInstance().addEmployee(employee);
            System.out.println("Employee successfully added!");
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response getAllEmployees(Request request) {
        Response response = new Response();
        
        try {

            ArrayList<Employee> list = ServerController.getInstance().getAllEmployees();
            System.out.println("Employees successfully fetched!");
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(list);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);

        }
        return response;
    }

    private Response deleteEmployee(Request request) {
        Response response = new Response();

        Employee e = (Employee) request.getArgument();
        try {
            ServerController.getInstance().deleteEmployee(e);
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }

        return response;
    }

    private Response updateEmployee(Request request) {
        Response response = new Response();
        Employee e = (Employee) request.getArgument();

        try {
            ServerController.getInstance().updateEmployee(e);
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response getAllLocations(Request request) {
        Response response = new Response();
        try {

            ArrayList<Location> list = ServerController.getInstance().getAllLocations();
            System.out.println("Locations successfully fetched!");
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(list);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);

        }
        return response;
    }

    private Response getAllApartmentFeatures(Request request) {
        Response response = new Response();
        try {

            ArrayList<ApartmentFeatures> list = ServerController.getInstance().getAllApartmentFeatures();
            System.out.println("Apartment features successfully fetched!");
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(list);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);

        }
        return response;
    }

    private Response addListing(Request request) {
        Response response = new Response();
        Listing listing= (Listing) request.getArgument();
        try {
            ServerController.getInstance().addListing(listing);
            System.out.println("Listing successfully added!");
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response getAllListings(Request request) {
        Response response = new Response();
        try {

            ArrayList<Listing> list = ServerController.getInstance().getAllListings();
            System.out.println("Listings successfully fetched!");
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(list);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);

        }
        return response;
    }

    private Response updateListing(Request request) {
        Response response = new Response();
        Listing l = (Listing) request.getArgument();

        try {
            ServerController.getInstance().updateListing(l);
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response deleteListing(Request request) {
        Response response = new Response();

        Listing l =  (Listing) request.getArgument();
        try {
            ServerController.getInstance().deleteListing(l);
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }

        return response;
    }

    private Response addRental(Request request) {
         Response response = new Response();
        Rental r = (Rental) request.getArgument();
        try {
            ServerController.getInstance().addRental(r);
            System.out.println("Rental successfully added!");
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response getAllRentals(Request request) {
         Response response = new Response();
        try {
            ArrayList<Rental> list = ServerController.getInstance().getAllRentals();
            System.out.println("Rentals successfully fetched!");
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(list);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
            System.out.println("Error : "+ex.getMessage());

        }
        return response;
    }

    private Response getAllFeatureValues(Request request) {
        Response response = new Response();
        try {
            ArrayList<FeatureValue> list = ServerController.getInstance().getAllFeatureValues();
            System.out.println("Feature values successfully fetched!");
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(list);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
            System.out.println("Error : "+ex.getMessage());

        }
        return response;
    }

    
}
