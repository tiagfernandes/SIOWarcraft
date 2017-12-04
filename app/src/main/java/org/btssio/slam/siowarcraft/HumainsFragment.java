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


public class HumainsFragment extends Fragment implements AdapterView.OnItemClickListener {

    MediaPlayer mp;
    ListView lv;
    String questions[] = {
            "Oui Messire", "Oui Monseigneur", "Pardon", "Prêt à travailler",
            "Qui y'a t'il ?", "Si vous le voulez", "Travail terminé", "Très bien",
            "Votre prénom", "Vous n'avez", "Arrrgh", "Bien", "Ca y est", "Encore du travail",
            "Il essaie de", "Il est bon", "Il pourrait", "Je m'en charge", "Je ne peux rien",
            "Je peux essayer", "Ne m'invitez", "Ouaaahhh"};

    Integer[] idSons = {
            R.raw.ouimessire, R.raw.ouimonseigneur, R.raw.pardon, R.raw.pretatravailler,
            R.raw.quiyatil, R.raw.sivouslevoulez, R.raw.travailtermine, R.raw.tresbien,
            R.raw.votreprenom, R.raw.vousnavez, R.raw.arrrgh, R.raw.bien, R.raw.cayestjesuis, R.raw.encoredutravail,
            R.raw.ilessaiedefairede, R.raw.ilestboncest,  R.raw.ilpourrait, R.raw.jemencharge, R.raw.jenepeuxrien,
            R.raw.jepeuxessayer, R.raw.neminvitez, R.raw.ouah
    };

    public HumainsFragment() {
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
                questions);
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
