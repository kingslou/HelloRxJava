package com.lou.kings.hellorxjava.fragment;

import android.databinding.DataBindingUtil;
import android.view.View;
import android.widget.EditText;

import com.lou.kings.hellorxjava.R;
import com.lou.kings.hellorxjava.databinding.FragmentDatabindingBinding;
import com.lou.kings.hellorxjava.fragment.model.User;

import butterknife.Bind;

/**
 * Created by YiMuTian on 2017/1/6.
 */

public class DataBindingFragment extends BaseFragment {

    @Bind(R.id.edit_input)
    EditText editText;
    //这个自动生成的databing 名称组合为Fragment+layout布局的下划线后面的字符+Binding
    private FragmentDatabindingBinding fragmentDatabindingBinding;

    @Override
    public int getContentViewID() {
        return R.layout.fragment_databinding;
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        fragmentDatabindingBinding = FragmentDatabindingBinding.bind(view);
    }

    @Override
    public void initData() {
        super.initData();
        User user = new User();
        user.setName("loujin");
        fragmentDatabindingBinding.setUser(user);
    }
}
