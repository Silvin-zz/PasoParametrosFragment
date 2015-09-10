package pikino.pasoparametrosfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by silviobravocado on 07/09/15.
 */
public class ListFragment extends Fragment implements View.OnClickListener {

    private LinearLayout             containerFragment;
    private ArrayList<PokemonEntity> pokemonList;
    private IPokemon                 pokemonManager;
    private int                      columNumber;
    private ImageButton              pressedButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View viewFragment       = inflater.inflate(R.layout.activity_list_fragment, container, false);
        this.containerFragment  = (LinearLayout) viewFragment.findViewById(R.id.list_content_fragment);
        this.pokemonManager     = (IPokemon)getActivity();
        this.columNumber        = 3;
        this.generateViewButtons();
        return viewFragment;

    }




    /**
     * Generamos los linears layouts y de ahi generamos dentro de cada linear layout 3 botones :)
     * a ver si sale :)
     */
    private void generateViewButtons() {

        LinearLayout myLinear   = new LinearLayout(getActivity());
        String   name;
        int      id;
        this.loadPokemons();

        for(int a = 0; a < this.pokemonList.size(); a++){   //Recorremos  todos los pokemones.
            if(a % this.columNumber == 0){
                if(a > 0){
                   this.containerFragment.addView(myLinear);
                }
                myLinear    = this.crateNewLinearLayout();  //creamos un nuevo Linear Layout
            }

            myLinear.addView(this.createButtonPokemon(this.pokemonList.get(a)));

        }
        this.containerFragment.addView(myLinear);

    }




    private void loadPokemons(){

        this.pokemonList = new ArrayList<>();
        this.pokemonList.add(new PokemonEntity(1, "Balbasur"    ,  getActivity().getResources().getString(R.string.balbasur_description)    , "3", "4", R.drawable.balbasur));
        this.pokemonList.add(new PokemonEntity(2, "Charizard"   ,  getActivity().getResources().getString(R.string.charizar_description)    , "3", "5", R.drawable.charizard));
        this.pokemonList.add(new PokemonEntity(3, "Charmander"  ,  getActivity().getResources().getString(R.string.charmander_description)  , "5", "3", R.drawable.charmander));
        this.pokemonList.add(new PokemonEntity(4, "Charmeleon"  ,  getActivity().getResources().getString(R.string.charmeleon_description)  , "4", "2", R.drawable.charmeleon));
        this.pokemonList.add(new PokemonEntity(5, "Ivysaur"     ,  getActivity().getResources().getString(R.string.ivysaur_description)     , "3", "5", R.drawable.ivysaur));
        this.pokemonList.add(new PokemonEntity(6, "Squirtle"    ,  getActivity().getResources().getString(R.string.squirtle_description)    , "3", "4", R.drawable.squirtle));
        this.pokemonList.add(new PokemonEntity(7, "Venusaur"    ,  getActivity().getResources().getString(R.string.squirtle_description)    , "5", "5", R.drawable.venusaur));
        this.pokemonList.add(new PokemonEntity(8, "blastoise"   ,  getActivity().getResources().getString(R.string.blastoise_description)   , "5", "5", R.drawable.blastoise));
        this.pokemonList.add(new PokemonEntity(9, "wartortle"   ,  getActivity().getResources().getString(R.string.wartortle_description)   , "3", "4", R.drawable.wartortle));

    }


    /**
     * Creamos un linear layout
     * @return LinearLayout
     */
    private LinearLayout crateNewLinearLayout(){

        LinearLayout myLinear            = new LinearLayout(getActivity());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                                                    ViewGroup.LayoutParams.WRAP_CONTENT,
                                                    ViewGroup.LayoutParams.WRAP_CONTENT);
        params.topMargin = 10;
        myLinear.setOrientation(LinearLayout.HORIZONTAL);
        myLinear.setLayoutParams(params);

        return myLinear;
    }


    /**
     * Creamos boton que representa un pokemon :)
     * @param pokemon
     * @return Button
     */
    private ImageButton createButtonPokemon(PokemonEntity pokemon){

        ImageButton buttonPokemon        = new ImageButton(getActivity());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                0,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        params.topMargin                 = 2;
        params.bottomMargin              = 2;
        params.leftMargin                = 10;
        params.rightMargin               = 2;
        params.weight                    = 1;
        buttonPokemon.setId(pokemon.getId());
        buttonPokemon.setImageResource(pokemon.getImage());
        buttonPokemon.setBackgroundColor(Color.rgb(228, 228, 228));
        buttonPokemon.setPadding(5, 5, 5, 5);
        buttonPokemon.setScaleType(ImageView.ScaleType.FIT_XY);
        buttonPokemon.setAdjustViewBounds(true);
        buttonPokemon.setLayoutParams(params);
        buttonPokemon.setOnClickListener(this);
        return buttonPokemon;

    }


    @Override
    public void onClick(View v) {
        if( pressedButton !=null){
            this.pressedButton.setBackgroundColor(Color.rgb(228, 228, 228));
        }
        this.pressedButton = (ImageButton) v;
        this.pressedButton.setBackgroundColor(Color.rgb(0,0,0));
        this.pokemonManager.shareData(this.findPokemonById(v.getId()));  //Enviamos los datos al activity

    }


    /**
     * Buscamos un pokemon por Id
     * @param id
     * @return
     */
    private PokemonEntity findPokemonById(int id){

        PokemonEntity myPokemon = new PokemonEntity();
        for (int a = 0; a < this.pokemonList.size(); a++){

            if(this.pokemonList.get(a).getId() == id){

                myPokemon = this.pokemonList.get(a);
                break;
            }
        }
        return myPokemon;
    }

}
