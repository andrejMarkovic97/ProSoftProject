/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.featurevalues;

import domain.FeatureValue;
import java.util.ArrayList;
import repository.db.impl.RepositoryFeatureValue;
import so.AbstractSO;

/**
 *
 * @author Andrej
 */
public class SOGetAllFeatureValues extends AbstractSO {

    private ArrayList<FeatureValue> list;
    private final RepositoryFeatureValue storageFeatureValue;

    public SOGetAllFeatureValues() {
        storageFeatureValue = new RepositoryFeatureValue();
    }
    
    @Override
    protected void precondition(Object param) throws Exception {
        long id = (long) param;
        if (id < 0) {
            throw new Exception("Invalid parametar");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        long id = (long) param;
        storageFeatureValue.connect();
        list = storageFeatureValue.getAllByID(id);
    }

    public ArrayList<FeatureValue> getList() {
        return list;
    }

}
