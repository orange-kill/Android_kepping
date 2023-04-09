package cn.itcast.keeping.ui.home;

import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import cn.itcast.keeping.MainActivity;
import cn.itcast.keeping.R;
import cn.itcast.keeping.ui.things.ThingsFragment;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("  ");
    }

    public LiveData<String> getText() {
        return mText;
    }
}