package com.apps.saijestudio.coffeenow;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class UserLocation extends Service {
    public UserLocation() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
