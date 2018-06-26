package com.idx.reader.subscribe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.idx.reader.R;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by steve on 17-9-21.
 * ListView条目
 */

public class MyBaseAdapter extends BaseAdapter {

    private Context mContext;
    private List<Subscribe> mList = new ArrayList<>();

    public MyBaseAdapter(Context context, List<Subscribe> list) {
        mContext = context;
        this.mList = list;
    }

    public MyBaseAdapter(List<Subscribe> mList) {
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.hot_item, null);
            viewHolder.subscribeImage = (ImageView)view.findViewById(R.id.iv_subscribe);
            viewHolder.subscribeTitle=(TextView)view.findViewById(R.id.tv_title);
            viewHolder.subscribeDesc= (TextView) view.findViewById(R.id.tv_desc);
            viewHolder.subscribeComment=(TextView) view.findViewById(R.id.tv_comment);
            viewHolder.subscribeType=(TextView) view.findViewById(R.id.tv_type);
            viewHolder.subscribeTime=(TextView) view.findViewById(R.id.tv_time);
            viewHolder.subscribeButtonDelete= (Button) view.findViewById(R.id.btn_delete);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Subscribe subscribe = mList.get(i);
        viewHolder.subscribeImage.setImageResource(subscribe.getImageId());
        viewHolder.subscribeTitle.setText(subscribe.getTitle());
        viewHolder.subscribeDesc.setText(subscribe.getDesc());
        viewHolder.subscribeComment.setText(subscribe.getComment());
        viewHolder.subscribeTime.setText(subscribe.getTime());
        String type=subscribe.getType();
        switch(type){
            case "1":
                viewHolder.subscribeType.setText("大事");
                break;
            case "2":
                viewHolder.subscribeType.setText("网友热议");
                break;
            default:
                viewHolder.subscribeType.setText("");
                break;
        }
        viewHolder.subscribeButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemDeleteListener.onDeleteClick(i);
            }
        });
        return view;
    }

    //删除按钮的监听接口
    public interface onItemDeleteListener {
        void onDeleteClick(int i);
    }

    private onItemDeleteListener mOnItemDeleteListener;

    public void setOnItemDeleteClickListener(onItemDeleteListener mOnItemDeleteListener) {
        this.mOnItemDeleteListener = mOnItemDeleteListener;
    }

    class ViewHolder {
        ImageView subscribeImage;
        TextView subscribeTitle;
        TextView subscribeDesc;
        TextView subscribeComment;
        TextView subscribeType;
        TextView subscribeTime;
        Button subscribeButtonDelete;
    }
}
