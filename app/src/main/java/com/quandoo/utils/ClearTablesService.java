package com.quandoo.utils;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.quandoo.base.dto.RefreshTables;
import com.quandoo.quandoo.model.db.ReservationsDBRepo;
import com.quandoo.quandoo.model.db.ReservationsDBRepoImpl;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Eslam Hussein on 11/25/17.
 */

public class ClearTablesService extends IntentService {

    public ClearTablesService() {
        super("ClearTablesService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        ReservationsDBRepo reservationsDBRepo = new ReservationsDBRepoImpl();
        reservationsDBRepo.clearRealmDataBaseReservation();
        EventBus.getDefault().post(new RefreshTables());

    }
}
