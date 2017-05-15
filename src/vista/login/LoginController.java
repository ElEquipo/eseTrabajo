package vista.login;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javax.swing.Timer;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class LoginController implements Initializable {

    private boolean mayusculasActivadas = false;
    /*ATRIBUTOS FXML*/
    @FXML
    private TextField tf_user;
    @FXML
    private Label lbl_inciarSesion;
    @FXML
    private Button bt_iniciarSesion;
    @FXML
    private Label lbl_bienvendio;
    @FXML
    private Separator separator;
    @FXML
    private Pane pn_inciarSesion;
    @FXML
    private Pane pn_principalBienvenida;
    @FXML
    private PasswordField pf_contraseña;
    @FXML
    private Label lb_errorIniciar;
    @FXML
    private ImageView iv_bloqMayus;
    @FXML
    private AnchorPane paneLogin;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        FadeTransition transicion = new FadeTransition(Duration.millis(5000), pn_principalBienvenida);
        transicion.setAutoReverse(true);
        transicion.setFromValue(1.0);
        transicion.setToValue(0.0);

        Timer timer = new Timer(1000, new ActionListener() { // Genera el difuminación del panel principal
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                transicion.play();
            }
        });
        timer.setRepeats(false);
        timer.start();

        Timer tiempoTransicion = new Timer(6000, new ActionListener() { // Permite que podemaos interactuar con el segundo panel
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                pn_principalBienvenida.setVisible(false);
            }
        });
        tiempoTransicion.setRepeats(false);
        tiempoTransicion.start();

        Image img_warnning = new Image("/vista/login/images/warningIcon3.png");
        iv_bloqMayus.setImage(img_warnning);
        iv_bloqMayus.setDisable(true);
        iv_bloqMayus.setVisible(false);
    }

    @FXML
    private void inciarSesionAction(ActionEvent event) {
        iniciarSesion();
    }

    public void iniciarSesion() {
        try {
            if (tf_user.getText().isEmpty() || pf_contraseña.getText().isEmpty()) {
                lb_errorIniciar.setText("Rellene los campos");
                lb_errorIniciar.setStyle("-fx-background-color:rgba(89, 89, 89, 0.6);"
                        + " -fx-border-radius:2px;");
            } else {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("/vista/gerente/GerenteFXML.fxml"));
                paneLogin.getChildren().setAll(pane);
            }

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void conectarAction(KeyEvent event) {
        KeyCode tecla = event.getCode();
//        boolean isOn = Toolkit.getDefaultToolkit().getLockingKeyState(java.awt.event.KeyEvent.VK_CAPS_LOCK);
//        System.out.println(isOn);
//        if (isOn) {
//            mayusculasActivadas = true;
//        }
//        
//        
//
//        if (mayusculasActivadas && pf_contraseña.isFocused()) {
//            iv_bloqMayus.setDisable(false);
//            iv_bloqMayus.setVisible(true);
//            mayusculasActivadas = false;
//            tf_user.setText("0");
//
//        } else if (!mayusculasActivadas && pf_contraseña.isFocused()) {
//            iv_bloqMayus.setDisable(false);
//            iv_bloqMayus.setVisible(true);
//            mayusculasActivadas = true;
//            tf_user.setText("1");
//
//        } else if (tecla == KeyCode.CAPS && pf_contraseña.isFocused() && mayusculasActivadas == true) {
//            iv_bloqMayus.setDisable(true);
//            iv_bloqMayus.setVisible(false);
//            mayusculasActivadas = false;
//            tf_user.setText("2");
//
//        } else if (tecla == KeyCode.CAPS && pf_contraseña.isFocused() && mayusculasActivadas == false) {
//            iv_bloqMayus.setDisable(true);
//            iv_bloqMayus.setVisible(false);
//            mayusculasActivadas = true;
//            tf_user.setText("3");
//
//        } else if (!pf_contraseña.isFocused() && mayusculasActivadas == true) {
//            iv_bloqMayus.setDisable(true);
//            iv_bloqMayus.setVisible(false);
//            mayusculasActivadas = false;
//            tf_user.setText("4");
//
//        } else if (!pf_contraseña.isFocused() && mayusculasActivadas == false) {
//            iv_bloqMayus.setDisable(true);
//            iv_bloqMayus.setVisible(false);
//            mayusculasActivadas = true;
//            tf_user.setText("5");
//
//        } else if (mayusculasActivadas == false) {
//            mayusculasActivadas = true;
//            tf_user.setText("6");
//
//        } else if (mayusculasActivadas == true) {
//            mayusculasActivadas = false;
//            tf_user.setText("7");
//        }

        if (tecla == KeyCode.ENTER) {
            iniciarSesion();
        }
    }

}
