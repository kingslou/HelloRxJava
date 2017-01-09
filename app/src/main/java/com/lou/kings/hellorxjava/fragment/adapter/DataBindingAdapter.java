package com.lou.kings.hellorxjava.fragment.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lou.kings.hellorxjava.BR;
import com.lou.kings.hellorxjava.R;
import com.lou.kings.hellorxjava.fragment.model.UserFilter;

import java.util.List;

import static android.databinding.tool.util.GenerationalClassUtil.ExtensionFilter.BR;

/**
 * Created by YiMuTian on 2017/1/9.
 */

public class DataBindingAdapter extends RecyclerView.Adapter<DataBindingAdapter.ViewHolder> {

    private Context mContext;
    private List<UserFilter> userList;
    public DataBindingAdapter(Context context,List<UserFilter> users){
        this.mContext = context;
        this.userList = users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = null;
//        view = LayoutInflater.from(mContext).inflate(R.layout.item_grild,parent,false);
        //DataBinding
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.item_grild,parent,false);
        ViewHolder viewHolder = new ViewHolder(viewDataBinding.getRoot());
        viewHolder.setViewDataBinding(viewDataBinding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserFilter user = userList.get(position);
        holder.getViewDataBinding().setVariable(com.lou.kings.hellorxjava.BR.userinfo,user);
        holder.getViewDataBinding().executePendingBindings();
//        holder.textView.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ViewDataBinding viewDataBinding;

        public void setViewDataBinding(ViewDataBinding viewDataBinding) {
            this.viewDataBinding = viewDataBinding;
        }

        public ViewDataBinding getViewDataBinding() {
            return viewDataBinding;
        }

        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
//             textView =(TextView)itemView.findViewById(R.id.textView8);
        }
    }

}
