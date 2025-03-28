package za.ac.cput.domain.repository;

import za.ac.cput.domain.entities.Residence;

import java.util.Set;

public interface IResidenceRepository extends IRepository <Residence, String> {
    Set<Residence> getAll();
}
