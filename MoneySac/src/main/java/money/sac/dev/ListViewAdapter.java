package money.sac.dev;

/**
 * Created by Kev1n on 05.10.13.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends ArrayAdapter<ListEntry> {
    private final Context context;
    private final ListEntry[] values;

    public ListViewAdapter(Context context, ListEntry[] values) {
        super(context, R.layout.listrow, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.listrow, parent, false);
        TextView textViewDesc = (TextView) rowView.findViewById(R.id.textViewListRowDesc);
        TextView textViewAmount = (TextView) rowView.findViewById(R.id.textViewListRowAmount);
        ImageView imageViewArrow = (ImageView) rowView.findViewById(R.id.imageViewListRowArrow);
        textViewDesc.setText(values[position].getDesc());
        textViewAmount.setText(values[position].getAmount()+"");
        // Change the icon for Windows and iPhone
        boolean isIncome = values[position].getIsIncome();
        if (isIncome) {
            imageViewArrow.setImageResource(R.drawable.arrow_green);
        } else {
            imageViewArrow.setImageResource(R.drawable.arrow_red);
        }

        return rowView;
    }
}
