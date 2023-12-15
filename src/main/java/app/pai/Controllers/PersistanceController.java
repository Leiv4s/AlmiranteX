package app.pai.Controllers;

import app.pai.models.ModelProduto;
import app.pai.models.ModelProdutoDefinicao;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

// Classe utilizada para serializar e desserializar objetos. Aqui se implementa
// a lógica de persistencia dos dados manipulados pelo usuário.
public class PersistanceController implements Serializable {


    class Aux implements Serializable {
        private String nomeProduto;
        private String tipoTamanho;
        private String unidadeTamanho;
        private String categoria;
        private String publicoAlvo;
        private String genero;
        private float precoCusto;
        private float precoVenda;

        public Aux(String nomeProduto, String tipoTamanho, String categoria, String publicoAlvo, String genero, float precoCusto, float precoVenda) {
            this.nomeProduto = nomeProduto;
            this.tipoTamanho = tipoTamanho;
            this.categoria = categoria;
            this.publicoAlvo = publicoAlvo;
            this.genero = genero;
            this.precoCusto = precoCusto;
            this.precoVenda = precoVenda;
        }

        public Aux(String nomeProduto, String tipoTamanho, String unidadeTamanho, String categoria, String publicoAlvo, String genero, float precoCusto, float precoVenda) {
            this.nomeProduto = nomeProduto;
            this.tipoTamanho = tipoTamanho;
            this.unidadeTamanho = unidadeTamanho;
            this.categoria = categoria;
            this.publicoAlvo = publicoAlvo;
            this.genero = genero;
            this.precoCusto = precoCusto;
            this.precoVenda = precoVenda;
        }

        public String getUnidadeTamanho() {
            return unidadeTamanho;
        }

        public void setUnidadeTamanho(String unidadeTamanho) {
            this.unidadeTamanho = unidadeTamanho;
        }

        public String getNomeProduto() {
            return nomeProduto;
        }

        public void setNomeProduto(String nomeProduto) {
            this.nomeProduto = nomeProduto;
        }

        public String getTipoTamanho() {
            return tipoTamanho;
        }

        public void setTipoTamanho(String tipoTamanho) {
            this.tipoTamanho = tipoTamanho;
        }

        public String getCategoria() {
            return categoria;
        }

        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }

        public String getPublicoAlvo() {
            return publicoAlvo;
        }

        public void setPublicoAlvo(String publicoAlvo) {
            this.publicoAlvo = publicoAlvo;
        }

        public String getGenero() {
            return genero;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public float getPrecoCusto() {
            return precoCusto;
        }

        public void setPrecoCusto(float precoCusto) {
            this.precoCusto = precoCusto;
        }

        public float getPrecoVenda() {
            return precoVenda;
        }

        public void setPrecoVenda(float precoVenda) {
            this.precoVenda = precoVenda;
        }
    }

    public ArrayList<ModelProduto> desserializeProdutoEstoque() {
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream("ProdutoEstoque.ser");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectInputStream objectInput = null;
        try {
            objectInput = new ObjectInputStream(fileInput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Aux> arrayCarregado;
        try {
            arrayCarregado = (ArrayList<Aux>) objectInput.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<ModelProduto> arrayProdutoEstoque = new ArrayList<>();
        ModelProdutoDefinicao produtoDefinicaoCarregado = new ModelProdutoDefinicao();
        SimpleStringProperty stringProperty = new SimpleStringProperty();
        ;
        for (Aux auxiliar : arrayCarregado) {
            System.out.println("oi vc n ta doido leivas");
            arrayProdutoEstoque.add(
                    new ModelProduto(
                            new ModelProdutoDefinicao(auxiliar.nomeProduto,
                                    auxiliar.tipoTamanho,
                                    auxiliar.categoria,
                                    auxiliar.publicoAlvo,
                                    auxiliar.genero,
                                    auxiliar.precoCusto,
                                    auxiliar.precoVenda),
                            new SimpleStringProperty(auxiliar.unidadeTamanho)));

        }
        System.out.println("cheguei aq");
        System.out.println(arrayProdutoEstoque);
        return arrayProdutoEstoque;

    }

    public void serializeProdutoEstoque(ObservableList<ModelProduto> list) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("ProdutoEstoque.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        ArrayList<Aux> auxArrayList = new ArrayList<>();

        for (ModelProduto produto : list) {
            auxArrayList.add(
                    new Aux(
                            produto.getProdutoDefinicao().getNomeProduto(),
                            produto.getProdutoDefinicao().getTipoTamanho(),
                            produto.getTamanho(),
                            produto.getProdutoDefinicao().getCategoria(),
                            produto.getProdutoDefinicao().getPublicoAlvo(),
                            produto.getProdutoDefinicao().getGenero(),
                            produto.getProdutoDefinicao().getPrecoCusto(),
                            produto.getProdutoDefinicao().getPrecoVenda()
                    )
            );
        }
        out.writeObject(new ArrayList<>(auxArrayList));
        out.close();
        fileOut.close();

    }

    public void serializeProdutoDefinicao(ObservableList<ModelProdutoDefinicao> list) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("ProdutoDefinicao.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        ArrayList<Aux> auxArrayList = new ArrayList<>();

        for (ModelProdutoDefinicao modelProdutoDefinicao : list) {
            auxArrayList.add(
                    new Aux(
                            modelProdutoDefinicao.getNomeProduto(),
                            modelProdutoDefinicao.getTipoTamanho(),
                            modelProdutoDefinicao.getCategoria(),
                            modelProdutoDefinicao.getPublicoAlvo(),
                            modelProdutoDefinicao.getGenero(),
                            modelProdutoDefinicao.getPrecoCusto(),
                            modelProdutoDefinicao.getPrecoVenda()
                    )
            );
        }
        out.writeObject(new ArrayList<>(auxArrayList));
        out.close();
        fileOut.close();

    }

    public void serializeCategoria(ObservableList<StringProperty> list) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("Categoria.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        ArrayList<String> auxArrayList = new ArrayList<>();

        try {
            for (StringProperty categoria : list) {
                auxArrayList.add(categoria.getValue());
            }
        } catch (Exception e) {
            System.out.println("buguei, mas foda-se tbm essa merda, to funcionando");
        }

        out.writeObject(new ArrayList<>(auxArrayList));
        out.close();
        fileOut.close();
    }

    public void serializePublicoAlvo(ObservableList<StringProperty> observableList) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("PublicoAlvo.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        ArrayList<String> stringList = new ArrayList<>();
        for (StringProperty stringProperty : observableList) {
            stringList.add(stringProperty.get());
        }

        out.writeObject(new ArrayList<>(stringList));
        out.close();
        fileOut.close();


    }

    public void serializeGenero(ObservableList<StringProperty> observableList) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("Genero.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        ArrayList<String> stringList = new ArrayList<>();
        for (StringProperty stringProperty : observableList) {
            stringList.add(stringProperty.get());
        }

        out.writeObject(new ArrayList<>(stringList));
        out.close();
        fileOut.close();

    }


    public ArrayList<ModelProdutoDefinicao> desserializeProdutoDefinicao() {
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream("ProdutoDefinicao.ser");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectInputStream objectInput = null;
        try {
            objectInput = new ObjectInputStream(fileInput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Aux> arrayCarregado;
        try {
            arrayCarregado = (ArrayList<Aux>) objectInput.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<ModelProdutoDefinicao> arrayProdutoDefinicao = new ArrayList<>();

        for (Aux aux : arrayCarregado) {
            arrayProdutoDefinicao.add(new ModelProdutoDefinicao(aux.nomeProduto, aux.categoria, aux.genero, aux.publicoAlvo, aux.tipoTamanho, aux.precoCusto, aux.precoVenda));
        }
        System.out.println("cheguei aq");
        return arrayProdutoDefinicao;

    }

    public ArrayList<StringProperty> desserializeCategoria() {
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream("Categoria.ser");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectInputStream objectInput = null;
        try {
            objectInput = new ObjectInputStream(fileInput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ArrayList<String> arrayCarregado;
        ArrayList<StringProperty> arrayCategoria = new ArrayList<>();

        try {
            arrayCarregado = (ArrayList<String>) objectInput.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (String array : arrayCarregado) {
            arrayCategoria.add(new SimpleStringProperty(array));
        }

        return arrayCategoria;

    }

    public ArrayList<String> desserializePublicoAlvo() {
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream("PublicoAlvo.ser");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectInputStream objectInput = null;
        try {
            objectInput = new ObjectInputStream(fileInput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            return (ArrayList<String>) objectInput.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<String> desserializeGenero() {
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream("Genero.ser");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectInputStream objectInput = null;
        try {
            objectInput = new ObjectInputStream(fileInput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            return (ArrayList<String>) objectInput.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
