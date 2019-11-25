package controller;

import java.util.ArrayList;
import java.util.Random;

import view.block.*;

/**
 *
 * @author Victor
 */
public final class BoardController {

    private static Random r = new Random();
    /*private static BoardController instance;

    private BoardController(BlockHolder[][] holders) {  
        this.createRandom(holders);
        this.createRandom(holders);
    }
    
    public static BoardController getInstance(BlockHolder[][] holders) {
        if (instance == null) {
            instance = new BoardController(holders);
        }
        return instance;
    }*/
    
    public static void createRandom(BlockHolder[][] holders){        
        try{
            ArrayList<Integer> freeI = new ArrayList();
            ArrayList<Integer> freeJ = new ArrayList();
            int number;
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    if(!holders[i][j].hasBlock()){
                        freeI.add(i);
                        freeJ.add(j);
                    }
                }           
            }
            int choosedPosition = r.nextInt(freeI.size());
            int choosedNumber = r.nextInt(10);
            if(choosedNumber < 2){                               //4 ou 2
                number = 4;
            }
            else{
                number = 2;
            }
            int selectedI = freeI.get(choosedPosition);         //coloca o valor sorteado na posicao sorteada
            int selectedJ = freeJ.get(choosedPosition);
            holders[selectedI][selectedJ].createBlock(number, false);            
        }   catch (Exception e) {
                System.out.println("Game Over");
            }
    }
    
    public static boolean moveLeft(BlockHolder [][] holders) {
        ColoredBlock [][] aux = new ColoredBlock[4][4];
        // Salva o estado atual dos Holders
        for(int i=0; i<4; i++){         
            for(int j=0; j<4; j++){
                aux[i][j] = holders[i][j].getBlock();
            }
        }        
        // Shifta pra Esquerda
        shiftLeft(holders);
        // Combina
        combineLeft(holders);
        // Shifta novamente
        shiftLeft(holders);
    
        // Verifica se algum bloco se moveu (ou combinou)
        return hasMoved(aux, holders);
    }

    public static boolean moveUp(BlockHolder [][] holders) {
        ColoredBlock [][] aux = new ColoredBlock[4][4];
        // Salva o estado atual dos Holders
        for(int i=0; i<4; i++){         
            for(int j=0; j<4; j++){
                aux[i][j] = holders[i][j].getBlock();
            }
        }
        // Shifta pra Cima
        shiftUp(holders);
        // Combina
        combineUp(holders);
        // Shifta novamente
        shiftUp(holders);
    
        // Verifica se algum bloco se moveu (ou combinou)
        return hasMoved(aux, holders);
    }

    public static boolean moveDown(BlockHolder [][] holders) {
        ColoredBlock [][] aux = new ColoredBlock[4][4];
        // Salva o estado atual dos Holders
        for(int i=0; i<4; i++){         
            for(int j=0; j<4; j++){
                aux[i][j] = holders[i][j].getBlock();
            }
        }
        // Shifta pra Baixo
        shiftDown(holders);
        // Combina
        combineDown(holders);
        // Shifta novamente
        shiftDown(holders);
    
        // Verifica se algum bloco se moveu (ou combinou)
        return hasMoved(aux, holders);
    }

    public static boolean moveRight(BlockHolder [][] holders) {
        ColoredBlock [][] aux = new ColoredBlock[4][4];
        // Salva o estado atual dos Holders
        for(int i=0; i<4; i++){         
            for(int j=0; j<4; j++){
                aux[i][j] = holders[i][j].getBlock();
            }
        }
        // Shifta pra Direita
        shiftRight(holders);
        // Combina
        combineRight(holders);
        // Shifta novamente
        shiftRight(holders);
    
        // Verifica se algum bloco se moveu (ou combinou)
        return hasMoved(aux, holders);
    }


    private static boolean hasMoved(ColoredBlock [][] aux, BlockHolder [][] holders) {
        for(int i=0; i<4; i++){         
            for(int j=0; j<4; j++){
                if (aux[i][j] != holders[i][j].getBlock())
                    return true;
            }
        }
        return false;
    }
    
    private static void shiftLeft(BlockHolder [][] holders){              
        for(int i=0; i<4; i++){
            int aux = -1;         
            for(int j=0; j<4; j++){
                if(holders[i][j].getBlock() == null && aux == -1){
                    aux = j;
                }
                else if(aux != -1 && holders[i][j].getBlock() != null){
                    holders[i][aux].setBlock(holders[i][j].removeBlock());                  
                    aux++;
                }   
            }
        }
    }

    private static void combineLeft(BlockHolder [][] holders){
        for(int i=0; i<4; i++){
            for(int j=0; j<3; j++){                
                if(holders[i][j].hasBlock() && holders[i][j+1].hasBlock() && holders[i][j].getBlock().getNumber() == holders[i][j+1].getBlock().getNumber()){
                    int aux = holders[i][j].purgeBlock().getNumber() + holders[i][j+1].purgeBlock().getNumber();
                    holders[i][j].createBlock(aux, true);
                }
            }
        }
    }
    private static void shiftRight(BlockHolder [][] holders){              
        for(int i=0; i<4; i++){
            int aux = -1;         
            for(int j=3; j>=0; j--){
                if(holders[i][j].getBlock() == null && aux == -1){
                    aux = j;
                }
                else if(aux != -1 && holders[i][j].getBlock() != null){
                    holders[i][aux].setBlock(holders[i][j].removeBlock());                  
                    aux--;
                }   
            }
        }
    }
    private static void combineRight(BlockHolder [][] holders){
        for(int i=0; i<4; i++){
            for(int j=3; j>0; j--){                
                if(holders[i][j].hasBlock() && holders[i][j-1].hasBlock() && holders[i][j].getBlock().getNumber() == holders[i][j-1].getBlock().getNumber()){                    
                    int aux = holders[i][j].purgeBlock().getNumber() + holders[i][j-1].purgeBlock().getNumber();
                    holders[i][j].createBlock(aux, true);                    
                }
            }
        }
    }
    
    private static void shiftUp(BlockHolder [][] holders){              
        for(int j=0; j<4; j++){
            int aux = -1;         
            for(int i=0; i<4; i++){
                if(holders[i][j].getBlock() == null && aux == -1){
                    aux = i;
                }
                else if(aux != -1 && holders[i][j].getBlock() != null){
                    holders[aux][j].setBlock(holders[i][j].removeBlock());                  
                    aux++;
                }   
            }
        }
    }
    private static void combineUp(BlockHolder [][] holders){
        for(int j=0; j<4; j++){
            for(int i=0; i<3; i++){                
                if(holders[i][j].hasBlock() && holders[i+1][j].hasBlock() && holders[i][j].getBlock().getNumber() == holders[i+1][j].getBlock().getNumber()){                    
                    int aux = holders[i][j].purgeBlock().getNumber() + holders[i+1][j].purgeBlock().getNumber();
                    holders[i][j].createBlock(aux, true);                    
                }
            }
        }
    }
    
    private static void shiftDown(BlockHolder [][] holders){              
        for(int j=0; j<4; j++){
            int aux = -1;         
            for(int i=3; i>=0; i--){
                if(holders[i][j].getBlock() == null && aux == -1){
                    aux = i;
                }
                else if(aux != -1 && holders[i][j].getBlock() != null){
                    holders[aux][j].setBlock(holders[i][j].removeBlock());                  
                    aux--;
                }   
            }
        }
    }
    private static void combineDown(BlockHolder [][] holders){
        for(int j=0; j<4; j++){
            for(int i=3; i>0; i--){                
                if(holders[i][j].hasBlock() && holders[i-1][j].hasBlock() && holders[i][j].getBlock().getNumber() == holders[i-1][j].getBlock().getNumber()){                    
                    int aux = holders[i][j].purgeBlock().getNumber() + holders[i-1][j].purgeBlock().getNumber();
                    holders[i][j].createBlock(aux, true);                    
                }
            }
        }
    }
    
    public static void easterEgg(BlockHolder [][] holders){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(holders[i][j].hasBlock()){
                    holders[i][j].purgeBlock();
                }
            }           
        }
        holders[2][1].createBlock(1024, true);
        holders[2][2].createBlock(1024, true);
    }
    
    private static void youWon(BlockHolder [][] holders){
        for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    if(holders[i][j].getBlock().getNumber() == 2048){
                        System.out.println("You Won");                       
                    }
                }           
            }
    }
}
