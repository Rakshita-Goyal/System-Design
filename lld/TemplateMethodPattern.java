package lld;
abstract class ModelTrainer {
public final void trainPipeline(String dataPath) {
        loadData(dataPath);
        preprocessData();
        trainModel();     
        evaluateModel();  
        saveModel();       
    }
     protected void loadData(String path) {
        System.out.println("[Common] Loading dataset from " + path);
    }

    protected void preprocessData() {
        System.out.println("[Common] Spreprocessing ");
    }
    protected void saveModel() {
        System.out.println("[Common] Saving model");
    }
    protected abstract void trainModel();
    protected abstract void evaluateModel();
}

class NeuralNetworkTrainer extends ModelTrainer {
    @Override
    protected void trainModel() {
        System.out.println("[NeuralNet] Training Neural Network");
    }

    @Override
    protected void evaluateModel() {
        System.out.println("[NeuralNet] Evaluating ");
    }

    @Override
    protected void saveModel() {
        System.out.println("[NeuralNet] Saving .h5 file");
    }
}
class DecisionTreeTrainer extends ModelTrainer {
    // Use the default preprocessData() (train/test split + normalize)

    @Override
    protected void trainModel() {
        System.out.println("[DecisionTree]training ");
        // pseudo-code: recursive splitting on features...
    }

    @Override
    protected void evaluateModel() {
        System.out.println("[DecisionTree] Computing ");
    }
}
public class TemplateMethodPattern {
    public static void main(String[] args) {

ModelTrainer nnTrainer = new NeuralNetworkTrainer();
        nnTrainer.trainPipeline("data/images/");

System.out.println();
        ModelTrainer dtTrainer = new DecisionTreeTrainer();
        dtTrainer.trainPipeline("data/iris.csv");

    }
}