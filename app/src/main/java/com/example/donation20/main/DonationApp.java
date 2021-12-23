package com.example.donation20.main;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.example.donation20.database.DBManager;
import com.example.donation20.models.Donation;

import java.util.ArrayList;
import java.util.List;

public class DonationApp extends Application {

    public final int target = 10000;
    public int totalDonated = 0;
    //public List<Donation> donations = new ArrayList<Donation>();
    public DBManager dbManager;

    public boolean newDonation(Donation donation)
    {
        boolean targetAchieved = totalDonated > target;
        if (!targetAchieved)
        {
            dbManager.add(donation);
            totalDonated += donation.amount;
        }
        else
        {
            Toast.makeText(this, "Target Exceeded!", Toast.LENGTH_SHORT).show();
        }
        return targetAchieved;
    }



}
