package com.mycompany.uxui;

public class UxUi {

    public static void main(String[] args) {
        User usuario01 = new User();
        
        if (usuario01.verificarUsuario("ohata", "123")) {
            System.out.println("Usuário encontrado: " + usuario01.nome);
        } else {
            System.out.println("Usuário ou senha incorretos.");
        }
    }
}
