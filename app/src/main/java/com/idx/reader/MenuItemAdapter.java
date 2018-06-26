package com.idx.reader;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.TextViewCompat;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shaoqi on 17-9-20.
 */
class LvMenuItem
{
    int type;
    public String name;
    int icon;
    public LvMenuItem(int icon, String name)
    {
        this.icon = icon;
        this.name = name;
        if (icon == NO_ICON && TextUtils.isEmpty(name))
        {
            type = TYPE_SEPARATOR;//分割线
        } else if (icon == NO_ICON)
        {
            type = TYPE_NO_ICON;
        } else
        {
            type = TYPE_NORMAL;
        }
        if (type != TYPE_SEPARATOR && TextUtils.isEmpty(name))
        {
            throw new IllegalArgumentException("you need set a name for a non-SEPARATOR item");
        }
    }

    public LvMenuItem(String name)
    {
        this(NO_ICON, name);
    }

    public LvMenuItem()
    {
        this(null);
    }

    private static final int NO_ICON = 0;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_NO_ICON = 1;
    public static final int TYPE_SEPARATOR = 2;
}

public class MenuItemAdapter extends BaseAdapter  implements View.OnClickListener
{
    private final int mIconSize;
    //此对象用来导入布局
    private LayoutInflater mInflater;
    //上下文对象
    private Context mContext;

    public MenuItemAdapter(Context context)
    {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mIconSize = context.getResources().getDimensionPixelSize(R.dimen.drawer_icon_size);//24dp
    }

    private List<LvMenuItem> mItems = new ArrayList<>(
            Arrays.asList(
                    new LvMenuItem("Item1"),
                    new LvMenuItem("Item2"),
                    new LvMenuItem("Item3"),
                    new LvMenuItem(),
                    new LvMenuItem(R.drawable.ic_menu_camera, "我的消息"),
                    new LvMenuItem(R.drawable.ic_menu_gallery, "每日签到"),
                    new LvMenuItem(R.drawable.ic_menu_manage, "阅读口味"),
                    new LvMenuItem(R.drawable.ic_menu_send, "阅读圈"),
                    new LvMenuItem(),
                    new LvMenuItem(R.drawable.ic_menu_camera,"已购和上传"),
                    new LvMenuItem(R.drawable.ic_menu_share, "笔记"),
                    new LvMenuItem(R.drawable.ic_menu_slideshow, "阅读历史"),
                    new LvMenuItem(R.drawable.ic_menu_gallery, "文章收藏"),
                    new LvMenuItem(),
                    new LvMenuItem(R.drawable.ic_menu_manage, "精彩活动"),
                    new LvMenuItem(R.drawable.ic_menu_send, "帮助与反馈")
            ));


    @Override
    //当系统开始绘制ListView的时候，首先调用getCount()方法。得到它的返回值，即ListView的长度
    public int getCount()
    {
        return mItems.size();
    }


    @Override
    public Object getItem(int position)
    {
        return mItems.get(position);
    }


    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public int getViewTypeCount()
    {
        return 3;
    }

    @Override
    public int getItemViewType(int position)
    {
        return mItems.get(position).type;
    }

    @Override
    //系统调用getView()方法，根据长度逐一绘制ListView的每一行。
    // 也就是说，如果让getCount()返回1，那么只显示一行。
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(mContext==null){
            mContext = parent.getContext();
        }
        LvMenuItem item = mItems.get(position);
        switch (item.type)
        {
            //正常绘制
            case LvMenuItem.TYPE_NORMAL:
                if (convertView == null)
                {
                    convertView = mInflater.inflate(R.layout.design_drawer_item, parent,
                            false);
                }
                TextView itemView = (TextView) convertView;
                itemView.setText(item.name);
                Drawable icon = mContext.getResources().getDrawable(item.icon);
                //setIconColor(icon);
                if (icon != null)
                {
                    icon.setBounds(0, 0, mIconSize, mIconSize);
                    TextViewCompat.setCompoundDrawablesRelative(itemView, icon, null, null, null);
                }
                break;
            //不含图标绘制
            case LvMenuItem.TYPE_NO_ICON:
                ViewHolder viewHolder = null;
                if(convertView == null){
                    if(item.name.equals("Item1")) {
                        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.zidingyi, null);
                    }else{
                        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.zidingyi1, null);
                    }
                    viewHolder = new ViewHolder();
                    viewHolder.mTv = (TextView) convertView.findViewById(R.id.mTv);
                    viewHolder.mBtn = (Button)convertView.findViewById(R.id.mBtn);
                    convertView.setTag(viewHolder);
                }
                //获取viewHolder实例
                viewHolder = (ViewHolder)convertView.getTag();
                //设置tag标记
                viewHolder.mBtn.setTag(R.id.btn,position);//添加此代码
                viewHolder.mBtn.setOnClickListener(this);
                //设置tag标记
                viewHolder.mTv.setTag(R.id.tv,position);//添加此代码
                SpannableStringBuilder  sb;
                ForegroundColorSpan fcs = new ForegroundColorSpan(Color.BLACK); // 设置字体颜色
                if(item.name.equals("Item1")){
                    sb  = new SpannableStringBuilder("余额  充值送红包"); // 包装字体内容
                    sb.setSpan(fcs, 4, 9, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                }else if(item.name.equals("Item2")) {
                    sb = new SpannableStringBuilder("红包 4 阅点");
                    sb.setSpan(fcs, 3, 4, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                }else {
                    sb = new SpannableStringBuilder("积分商城 5 积分");
                    sb.setSpan(fcs, 5, 6, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                }
                viewHolder.mTv.setText(sb);
                viewHolder.mTv.setOnClickListener(this);
                break;
            case LvMenuItem.TYPE_SEPARATOR:
                if (convertView == null)
                {
                    convertView = mInflater.inflate(R.layout.design_drawer_item_separator,
                            parent, false);
                }
                break;
        }
        return convertView;
    }

    public void setIconColor(Drawable icon)
    {
        int textColorSecondary = android.R.attr.textColorSecondary;
        TypedValue value = new TypedValue();
        if (!mContext.getTheme().resolveAttribute(textColorSecondary, value, true))
        {
            return;
        }
        int baseColor = mContext.getResources().getColor(value.resourceId);
        icon.setColorFilter(baseColor, PorterDuff.Mode.MULTIPLY);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mBtn:
                int b = (int) view.getTag(R.id.btn);
                Toast.makeText(mContext,"我是按钮 " + b,Toast.LENGTH_SHORT).show();
                break;
            case R.id.mTv:
                int t = (int)view.getTag(R.id.tv);
                Toast.makeText(mContext,"我是文本" + t,Toast.LENGTH_SHORT).show();
                break;
        }
    }
    static class ViewHolder{
        TextView mTv;
        Button mBtn;
    }
}