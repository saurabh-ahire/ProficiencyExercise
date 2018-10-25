package saurabh.test.com.proficiencyexercise.viewmodel;

import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import saurabh.test.com.proficiencyexercise.model.data.CanadaInformation;

/**
 * This is a viewmodel class which hold the reference of the variables .
 * Created by saurabha on 25/10/18.
 */
public class CanadaInformationViewModel extends ViewModel {

    List<CanadaInformation> canadaInformationList;

    public List<CanadaInformation> getCanadaInformationList() {
        if (canadaInformationList == null) {
            canadaInformationList=new ArrayList<>();
        }
        return canadaInformationList;
    }

    public void setCanadaInformationList(List<CanadaInformation> canadaInformationList) {
        this.canadaInformationList = canadaInformationList;
    }
}
