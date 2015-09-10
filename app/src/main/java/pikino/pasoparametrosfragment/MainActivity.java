package pikino.pasoparametrosfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements IPokemon {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    /**
     * Recibimos datos de un pokemon
     * @param pokemon
     */
    @Override
    public void shareData(PokemonEntity pokemon) {

        if(this.isFragmentDetailVisible()){        //Evaluamos si esta visible el fragmento

            Log.d("resultado", "***** detail_fragment_table esta activa");
            DetailFragment detailFragment =  (DetailFragment)getSupportFragmentManager()
                                            .findFragmentById(R.id.detail_fragment_tablet);
            detailFragment.setPokemonDetail(pokemon);

        }
        else {
            Log.d("resultado", "***** detail_fragment_table No esta activa");
            this.gotoDetailActivity(pokemon);
        }

    }

    private void gotoDetailActivity(PokemonEntity pokemon){

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtras(this.getPokemonBuntle(pokemon));
        startActivity(intent);

    }

    private Bundle getPokemonBuntle(PokemonEntity pokemon) {
        Bundle dictionary = new Bundle();

        dictionary.putString("name"         , pokemon.getName());
        dictionary.putString("description"  , pokemon.getDescription());
        dictionary.putString("attack"       , pokemon.getAttack());
        dictionary.putString("defense"      , pokemon.getDefense());
        dictionary.putInt("imagesource"     , pokemon.getImage());

        return dictionary;


    }
    private boolean isFragmentDetailVisible(){

        return (    getSupportFragmentManager().findFragmentById(R.id.detail_fragment_tablet) != null
                 && getSupportFragmentManager().findFragmentById(R.id.detail_fragment_tablet).isVisible()
                );
    }
}
