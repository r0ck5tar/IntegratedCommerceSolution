/*

Copyright Baglio Michaël M2 IFI/AL -> Webservice : FedPS

 */
package fr.unice.polytech.soa1.FedPS.business;

import javax.xml.bind.annotation.XmlEnum;

public enum Status {
    STORAGE,IN_TRANSIT,DELIVERED,WAITING_FOR_PICK_UP,ARRIVAL_SCAN,CUSTOMS,UNKNOWN,LATE_DELIVERY;
}