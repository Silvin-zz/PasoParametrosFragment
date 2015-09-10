package pikino.pasoparametrosfragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //con esto activiamos el boton de retorno. En el manifest tabien se debe poner la propiedad parentActivityName
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle pokemonData              = getIntent().getExtras();
        PokemonEntity pokemon           = new PokemonEntity(1,
                                            pokemonData.getString("name"        , ""),
                                            pokemonData.getString("description" , ""),
                                            pokemonData.getString("attack"      , ""),
                                            pokemonData.getString("defense"     , ""),
                                            pokemonData.getInt("imagesource", 0)
                                        );


        DetailFragment detailFragment   = (DetailFragment) getSupportFragmentManager()
                                            .findFragmentById(R.id.detail_fragment);
        detailFragment.setPokemonDetail(pokemon);


    }




}
