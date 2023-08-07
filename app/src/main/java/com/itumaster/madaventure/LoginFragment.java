package com.itumaster.madaventure;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.itumaster.madaventure.model.ApiResponse;
import com.itumaster.madaventure.model.Utilisateur;
import com.itumaster.madaventure.model.minterface.ApiResponseListener;
import com.itumaster.madaventure.service.AuthentificationService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "Login Fragment - Log";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnButtonClickListener buttonClickListener;



    private TextView errorMessageText;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public interface OnButtonClickListener {
        void onButtonClicked(String username);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            buttonClickListener = (OnButtonClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnButtonClickListener");
        }
    }

    private String getUsernameFromForm() {
        EditText usernameEditText = getView().findViewById(R.id.usernameEditText); // Utilisez le bon ID pour votre champ de nom d'utilisateur
        return usernameEditText.getText().toString().trim();
    }

    private String getPasswordFromForm() {
        EditText usernameEditText = getView().findViewById(R.id.passwordEditText); // Utilisez le bon ID pour votre champ de nom d'utilisateur
        String password = usernameEditText.getText().toString();
        return password;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        /*MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity != null) {
            mainActivity.hideButtons();
        }*/

        errorMessageText = rootView.findViewById(R.id.errorMessage);

        Button buttonLogin = rootView.findViewById(R.id.loginButton);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Vérifiez les informations du formulaire et obtenez le nom d'utilisateur
                String username = getUsernameFromForm(); // Remplacez par votre code
                String password = getPasswordFromForm();

                performLogin();

//
//                SessionManager.getInstance().setLoggedInUser(username);
//
//                // Appelez la méthode de l'interface pour diriger vers le fragment Accueil
//                buttonClickListener.onButtonClicked(username);
            }
        });

        Button signupButton = rootView.findViewById(R.id.signupButton);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignupFragment signupFragment = new SignupFragment();
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, signupFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return rootView;
    }

    private void performLogin() {
        String email = getUsernameFromForm();
        String password = getPasswordFromForm();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            // Gérer le cas où l'email ou le mot de passe est vide

            errorMessageText.setBackgroundColor(getResources().getColor(R.color.alizarin, getContext().getTheme()));
            errorMessageText.setText("Veuillez remplir les champs.");
            errorMessageText.setTextColor(getResources().getColor(R.color.white, getContext().getTheme()));
            errorMessageText.setVisibility(View.VISIBLE);
            return;
        }

        Utilisateur utilisateur = new Utilisateur(email, password);
        try {
            AuthentificationService.login(utilisateur, new ApiResponseListener<Utilisateur>() {

                @Override
                public void onSuccess(Utilisateur loggedInUser) {
                    // Gérer la connexion réussie
                    errorMessageText.setBackgroundColor(getResources().getColor(R.color.emarald, getContext().getTheme()));
                    errorMessageText.setText("Success");
                    errorMessageText.setTextColor(getResources().getColor(R.color.white, getContext().getTheme()));
                    errorMessageText.setVisibility(View.VISIBLE);
                }

                @Override
                public void onError(String errorMessage) {
                    // Gérer l'échec de la connexion
                    errorMessageText.setBackgroundColor(getResources().getColor(R.color.alizarin, getContext().getTheme()));
                    errorMessageText.setText(errorMessage);
                    errorMessageText.setTextColor(getResources().getColor(R.color.white, getContext().getTheme()));
                    errorMessageText.setVisibility(View.VISIBLE);
                }
            });
        } catch (Exception ee) {
            Log.d(TAG, "performLogin: "+ee.getMessage());
        }
        

    }

}