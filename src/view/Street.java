package view;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.nio.file.*;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Street {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Street window = new Street();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Street() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 1363, 562);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Label para a instruir o usário
		JLabel lblInstrucao = new JLabel("Clique no bot\u00E3o abiaxo para buscar e receba uma lista de ruas de pa\u00EDses.");		
		lblInstrucao.setFont(new Font("Arial", Font.PLAIN, 14));
		lblInstrucao.setBounds(22, 11, 561, 14);
		frame.getContentPane().add(lblInstrucao);
		
		//Receba a lista de ruas dos paises
		JTextArea textAreaPaises = new JTextArea();
		textAreaPaises.setBounds(22, 89, 1315, 377);
		frame.getContentPane().add(textAreaPaises);
		
		
		//A ação para fazer a busca da lista de ruas
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Path caminho = Paths.get("C://Users//Romário Campos//Documents//Projetos//JAVA//LerArquivo//orders.csv");
				try {
					byte [] texto = Files.readAllBytes(caminho);
					String leitura = new String(texto);
					
					if (leitura != null ) {
						textAreaPaises.append(leitura);
					}
					
					
				}catch(Exception erro){
					
				}
			}
		});
		btnBuscar.setBounds(22, 55, 152, 23);
		frame.getContentPane().add(btnBuscar);
	}
}
