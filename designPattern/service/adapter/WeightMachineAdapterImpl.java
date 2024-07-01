package all_projects.src.designPattern.service.adapter;

public class WeightMachineAdapterImpl implements WeeigtMachineAdapter{

    WeightMachine weightMachine;
    WeightMachineAdapterImpl(WeightMachine weightMachine){
        this.weightMachine= weightMachine;
    }


    @Override
    public int getWeightInKgs() {
        return (int) (weightMachine.getWeight() * 0.45);
    }
}
