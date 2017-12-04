package org.btssio.slam.siowarcraft;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class OrcsFragment extends Fragment implements AdapterView.OnItemClickListener {

    ListView lv;
    MediaPlayer mp;

    String sons[] = {
            "Fracasse", "ARRHHH", "Tuer !", "Srug ! Srug !", "Scouapou", "Gloctard",
            "Dabou", "Quoi ?", "Maître", "Hein ?", "Oui", "Pour la Horde !",
            "Ma vie pour la Horde", "Je ne suis pas", "Il craint le grand méchant",
            "Panpan", "Le premier qui rira", "Je te tiens...", "Occupez vous de votre",
            "Quoi encore", "Orh! Orgh !", "Ouhhh"
    };

    Integer[] idSons = {
            R.raw.fracasse, R.raw.arrrgh, R.raw.tuer, R.raw.srugsrug, R.raw.scouapou, R.raw.gloctar,
            R.raw.dabou, R.raw.quoi, R.raw.maitre, R.raw.hein, R.raw.oui, R.raw.pourlahorde,
            R.raw.maviepourlahorde, R.raw.jenesuispas, R.raw.ilcraintlemechant,
            R.raw.panpan, R.raw.lepremierquirira, R.raw.jetetienstumetiens, R.raw.occupezvousdevotre,
            R.raw.quoiencore, R.raw.orhorgh, R.raw.ouhhh
    };

    public OrcsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_humains, container, false);
        ArrayAdapter adtr = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,
                sons);
        lv = (ListView) v.findViewById(R.id.listHums);
        lv.setAdapter(adtr);
        lv.setOnItemClickListener(this);
        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (mp != null) {
            mp.reset();
            mp.release();
        }
        mp = MediaPlayer.create(getActivity(), idSons[position]);
        mp.start();
    }
}
