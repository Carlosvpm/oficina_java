package entities;

import shared.baseEntity;

public class Professor extends baseEntity {

    private String matricula;
    private String especializacao;		

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }
    
    public String getEspecializacao() {
    	return this.especializacao;			
    }

    
}
