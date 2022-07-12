/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.featurevalues;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.FeatureValue;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Andrej
 */
public class SOGetAllFeatureValues extends AbstractSO {

    private ArrayList<FeatureValue> list;

    @Override
    protected void precondition(AbstractDomainObject ado) throws Exception {
       if (!(ado instanceof FeatureValue)) {
            throw new Exception("The object that has been sent is not a instance of class FeatureValue!");
        }
    }

    public ArrayList<FeatureValue> getList() {
        return list;
    }

    @Override
    protected void executeOperation(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> narudzbine = DBBroker.getInstance().select(ado);
        list = (ArrayList<FeatureValue>) (ArrayList<?>) narudzbine;
    }

}
