package py.com.thundersoda.samplestudio.mvc.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import py.com.thundersoda.samplestudio.R;
import py.com.thundersoda.samplestudio.mvc.model.Address;
import py.com.thundersoda.samplestudio.mvc.model.Site;
import py.com.thundersoda.samplestudio.mvc.model.User;

public class UserAdapter extends BaseAdapter {
    Context context;
    ArrayList<User> data;
    LayoutInflater inflater;

    public UserAdapter(@NonNull Context context, int resource, ArrayList<User> data) {
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    class ViewHolder {
        TextView name;
        TextView description;
        TextView siteName;
        TextView siteUrl;
        TextView city;
    }

    @Override
    public int getCount() {
        return this.data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder v;
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.data_item_list, parent, false);
            v = new ViewHolder();
            v.name = convertView.findViewById(R.id.name);
            v.description = convertView.findViewById(R.id.desc);
            v.siteName = convertView.findViewById(R.id.siteName);
            v.siteUrl = convertView.findViewById(R.id.siteUrl);
            v.city = convertView.findViewById(R.id.city);
            convertView.setTag(v);
        }
        else {
            v = (ViewHolder)convertView.getTag();
        }

        User user = data.get(position);

        Address address = user.getAddress();

        v.name.setText(user.getName());

        v.description.setText(user.getDescription());

        v.city.setText(address.getCity());
        Log.e("site", String.valueOf(user.getSites()));

        StringBuffer stringBuffer = new StringBuffer();
        for(Site site : user.getSites()) {
            stringBuffer.append(site.getName() + "\n" + site.getUrl() + "\n");
        }

        v.siteName.setText(stringBuffer);

        return convertView;
    }
}
