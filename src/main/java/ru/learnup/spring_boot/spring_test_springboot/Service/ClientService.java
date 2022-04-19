package ru.learnup.spring_boot.spring_test_springboot.Service;

import ru.learnup.spring_boot.spring_test_springboot.entity.Client;

import java.util.List;

public interface ClientService {

    public List<Client> getAllClients();

    public Client getClientById(int id);

    public void saveClient(Client client);

    public void deleteClient(int id);

}
