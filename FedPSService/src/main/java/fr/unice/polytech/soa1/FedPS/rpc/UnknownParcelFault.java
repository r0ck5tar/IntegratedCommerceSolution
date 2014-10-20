/*

Copyright Baglio Michaël M2 IFI/AL -> Webservice : FedPS

 */
package fr.unice.polytech.soa1.FedPS.rpc;

public class UnknownParcelFault extends Exception{

    private static final long serialVersionUID = 747892548956321754L;


    public UnknownParcelFault(String id) {
		super("Unknown Parcel: [" + id + "]");
	}
}