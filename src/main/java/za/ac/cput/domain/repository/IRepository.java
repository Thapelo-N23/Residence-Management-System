//222260971 Thapelo Ngwenya
//230640893 Phindile Lisa Ngozi
//230023967 Mengezi Junior Ngwenya
//230666426 Tsireledzo Netshilonwe
//230741754 Onako Ntsaluba
// 230277845 Olwethu Nene

package za.ac.cput.domain.repository;

import za.ac.cput.domain.entities.Residence;            //Thapelo Ngwenya 222260971

import java.util.Set;

public interface IRepository<T, ID> {
    T create (T t);
    T read (ID id);
    T update (T t);
    boolean delete (String id);
}
