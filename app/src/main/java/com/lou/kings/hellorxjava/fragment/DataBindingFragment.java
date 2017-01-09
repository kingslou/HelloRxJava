package com.lou.kings.hellorxjava.fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lou.kings.hellorxjava.BR;
import com.lou.kings.hellorxjava.R;
import com.lou.kings.hellorxjava.databinding.FragmentDatabindingBinding;
import com.lou.kings.hellorxjava.databinding.ItemGrildBinding;
import com.lou.kings.hellorxjava.fragment.adapter.BaseAdapter;
import com.lou.kings.hellorxjava.fragment.adapter.BaseViewHolder;
import com.lou.kings.hellorxjava.fragment.adapter.DataBindingAdapter;
import com.lou.kings.hellorxjava.fragment.model.User;
import com.lou.kings.hellorxjava.fragment.model.UserFilter;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by YiMuTian on 2017/1/6.
 */

public class DataBindingFragment extends BaseFragment {

    @Bind(R.id.recyclerView)
    RecyclerView grildRecyclerView;

    //这个自动生成的databing 名称组合为Fragment+layout布局的下划线后面的字符+Binding
    private FragmentDatabindingBinding fragmentDatabindingBinding;
    private ItemGrildBinding itemGrildBinding;
    private BaseAdapter baseAdapter;

    private List<UserFilter> userList = new ArrayList<>();

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
//
        for(int i=0;i<50;i++){
            UserFilter user1 = new UserFilter("张三"+i,i+10+"");
            userList.add(user1);
        }
        initAdapter();
    }

    void initAdapter(){

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        grildRecyclerView.setLayoutManager(gridLayoutManager);
        grildRecyclerView.setHasFixedSize(true);
//        DataBindingAdapter dataBindingAdapter = new DataBindingAdapter(getContext(),userList);
//        grildRecyclerView.setAdapter(dataBindingAdapter);
        baseAdapter = new BaseAdapter() {
            @Override
            protected void onBindView(BaseViewHolder holder, int position) {
                UserFilter userFilter = userList.get(position);
                holder.getViewDataBinding().setVariable(BR.userinfo,userFilter);
                holder.getViewDataBinding().executePendingBindings();
            }

            @Override
            protected int getLayoutID(int position) {
                return R.layout.item_grild;
            }

            @Override
            public int getItemCount() {
                return userList.size();
            }
        };
        grildRecyclerView.setAdapter(baseAdapter);
    }
}
