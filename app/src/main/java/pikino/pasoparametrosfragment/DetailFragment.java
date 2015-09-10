package pikino.pasoparametrosfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by silviobravocado on 07/09/15.
 */
public class DetailFragment extends android.support.v4.app.Fragment {

    private LinearLayout    containerFragment;
    private ImageView       imageLogo;
    private TextView        txtTitle;
    private TextView        txtDescription;
    private TextView        txtAttack;
    private TextView        txtDefense;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewFragment       = inflater.inflate(R.layout.activity_detail_fragment, container, false);
        this.containerFragment  = (LinearLayout) viewFragment.findViewById(R.id.detail_content_fragment);
        this.imageLogo          = (ImageView) viewFragment.findViewById(R.id.thumbnail);
        this.txtTitle           = (TextView)  viewFragment.findViewById(R.id.txt_title);
        this.txtDescription     = (TextView)  viewFragment.findViewById(R.id.txt_description);
        this.txtAttack          = (TextView)  viewFragment.findViewById(R.id.txt_attack);
        this.txtDefense         = (TextView)  viewFragment.findViewById(R.id.txt_defense);

        return viewFragment;

    }


    /**
     * Seteamos los valores que se veran en la interfaz de detalle.
     * @param pokemon
     */
    public void setPokemonDetail(PokemonEntity pokemon){

        this.txtTitle.setText(pokemon.getName());
        this.imageLogo.setBackgroundResource(pokemon.getImage());
        this.txtDescription.setText(pokemon.getDescription());
        this.txtAttack.setText(pokemon.getAttack());
        this.txtDefense.setText(pokemon.getDefense());
    }


    @Override
    public void onPause() {
        super.onPause();
        Log.d("resultado", "pausado");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("resultado", "stop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("resultado", "destroy view");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("resultado", "destroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("resultado", "detach");
    }
}
