package entities;

import java.util.List;

import shared.baseEntity;

public class Professor extends baseEntity {

    private String matricula;
    private List<Turma> turmas;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    
}
