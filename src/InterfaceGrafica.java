// InterfaceGrafica.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;     // <--- import necessário


public class InterfaceGrafica extends JFrame {
    private JTextArea areaTexto;
    private JButton botaoEstoque;
    private JButton botaoItens;

    public InterfaceGrafica() {
        super("PUC ACHADOS");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Área de texto
        areaTexto = new JTextArea("BEM VINDO AO PUC ACHADOS\nSELECIONE SUA AÇÃO");
        areaTexto.setEditable(false);
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        // Botões
        botaoEstoque = new JButton("Exibir Estoque");
        botaoItens   = new JButton("Exibir Itens");

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(botaoEstoque);
        painelBotoes.add(botaoItens);
        add(painelBotoes, BorderLayout.SOUTH);

        // Ação do botão Estoque
        botaoEstoque.addActionListener(e -> {
            ArrayList<Item> itensEstoque = Estoque.carregarDoArquivo();
            StringBuilder sb = new StringBuilder("Itens no Estoque:\n\n");
            for (Item item : itensEstoque) {
                sb.append("ID: ").append(item.getIdItem())
                  .append(", Nome: ").append(item.getNomeItem())
                  .append(", Categoria: ").append(item.getCategoria())
                  .append(", Descrição: ").append(item.getDecricao())
                  .append("\n");
            }
            areaTexto.setText(sb.toString());
        });

        // Ação do botão Itens
        botaoItens.addActionListener(e -> {
            ArrayList<Item> itensSistema = ArmazenadorDeItem.carregarDoArquivo();
            StringBuilder sb = new StringBuilder("Itens no Sistema:\n\n");
            for (Item item : itensSistema) {
                sb.append("ID: ").append(item.getIdItem())
                  .append(", Nome: ").append(item.getNomeItem())
                  .append(", Categoria: ").append(item.getCategoria())
                  .append(", Descrição: ").append(item.getDecricao())
                  .append("\n");
            }
            areaTexto.setText(sb.toString());
        });

        // Traz janela para frente e foca
        setVisible(true);
        setAlwaysOnTop(true);
        toFront();
        requestFocus();
        setAlwaysOnTop(false);

        // Listener de fechamento
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("===============================");
                System.out.println("INTERFACE GRAFICA FECHADA");
                System.out.println("===============================");
                System.out.println("1 - Cadastrar Usuário");
                System.out.println("2 - Registrar Item");
                System.out.println("3 - Exibir itens cadastrados");
                System.out.println("4 - Adicionar Item ao Estoque");
                System.out.println("5 - Retirar Item do Estoque");
                System.out.println("6 - Modificar Dados de Usuário");
                System.out.println("7 - Exibir Usuários");
                System.out.println("8 - Executar Interface Grafica");
                System.out.println("9 - Executar pesquisa por Nome do item");
                System.out.println("0 - Sair");
                System.out.println("===============================");
            }
        });
    }
}
