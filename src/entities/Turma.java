package entities;

import java.util.LinkedList;
import java.util.List;

public class Turma {
    private Professor professor;

    private List<Aluno> alunos = new LinkedList<>();

    private String ano;
    private String sala;

    public void Turma(String ano, String sala, Professor professor, List<Aluno> alunos) {

        this.alunos = alunos;
        this.ano = ano;
        this.professor = professor;
        this.sala = sala;

    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public String getAno() {
        return ano;
    }

    public Professor getProfessor() {
        return professor;
    }

    public String getSala() {
        return sala;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

}
