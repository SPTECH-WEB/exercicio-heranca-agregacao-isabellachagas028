package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores=new ArrayList<>();

    public Consultoria() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public void contratar(Desenvolvedor desenvolvedor){
        if(desenvolvedores.size()<vagas){
            desenvolvedores.add(desenvolvedor);

        }
    }
    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if(desenvolvedor.isFullstack()){
            desenvolvedores.add(desenvolvedor);

        }
    }
    public Double getTotalSalarios(){
        Double total=0.00;
        for(Desenvolvedor dev:desenvolvedores){
            total+=dev.calcularSalario();
        }
        return total;
    }
    public Integer qtdDesenvolvedoresMobile(){
        Integer total=0;
        for (Desenvolvedor dev:desenvolvedores){
            if (dev instanceof DesenvolvedorMobile){
                total++;
            }
        }
        return total;
    }
    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor>desenvolvedoresSalario=new ArrayList<>();
        for (Desenvolvedor dev:desenvolvedores){
            if (dev.calcularSalario()>=salario){
                desenvolvedoresSalario.add(dev);
            }
        }
        return desenvolvedoresSalario;
    }
    public Desenvolvedor buscarMenorSalario(){
        if (desenvolvedores.isEmpty()){
            return null;
        }
    Desenvolvedor menorSalario=desenvolvedores.get(0);
    for (Desenvolvedor dev:desenvolvedores){
        if (dev.calcularSalario()<menorSalario.calcularSalario()){
            menorSalario=dev;
        }
    }
    return menorSalario;
    }
    public List<Desenvolvedor>buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor>desenvolvedorestecnologia=new ArrayList<>();
        for (Desenvolvedor dev:desenvolvedores){
            if (dev instanceof DesenvolvedorMobile){
                if (((DesenvolvedorMobile) dev).getPlataforma()==tecnologia){
                    desenvolvedorestecnologia.add(dev);
                }
                if(((DesenvolvedorMobile) dev).getLinguagem()==tecnologia){
                    desenvolvedorestecnologia.add(dev);

                }

            }
            else if(dev instanceof DesenvolvedorWeb){
                if(((DesenvolvedorWeb) dev).getFrontend()==tecnologia){
                    desenvolvedorestecnologia.add(dev);

                }
                if (((DesenvolvedorWeb) dev).getBackend()==tecnologia){
                    desenvolvedorestecnologia.add(dev);

                }
                if (((DesenvolvedorWeb) dev).getSgbd()==tecnologia){
                    desenvolvedorestecnologia.add(dev);
                }
            }
        }
        return desenvolvedorestecnologia;
    }
    public Double getTotalSalariosPorTecnologia(String tecnologia){
        Double total=0.00;
        for (Desenvolvedor dev:desenvolvedores){
            if (dev instanceof DesenvolvedorMobile){
                if (((DesenvolvedorMobile) dev).getPlataforma()==tecnologia){
                    total+= dev.calcularSalario();
                }
                if(((DesenvolvedorMobile) dev).getLinguagem()==tecnologia){
                    total+= dev.calcularSalario();

                }

            }
            else if(dev instanceof DesenvolvedorWeb){
                if(((DesenvolvedorWeb) dev).getFrontend()==tecnologia){
                    total+= dev.calcularSalario();

                }
                if (((DesenvolvedorWeb) dev).getBackend()==tecnologia){
                    total+= dev.calcularSalario();

                }
                if (((DesenvolvedorWeb) dev).getSgbd()==tecnologia){
                    total+= dev.calcularSalario();
                }
            }
        }
        return total;
    }
}
