package cn.itcast.keeping.ui.wreath;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WreathViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public WreathViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is wreath fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}



