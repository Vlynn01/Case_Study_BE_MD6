package com.example.case_study_be_md6.repository;

import com.example.case_study_be_md6.model.PostEnterprise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IPostEnterpriseRepo extends PagingAndSortingRepository<PostEnterprise, Integer> {
    @Query(nativeQuery = true, value = "select  * from Case_Study_MD6.post_enterprise")
    List<PostEnterprise> getAll(Pageable pageable);

    @Query(nativeQuery = true, value = "select  * from Case_Study_MD6.post_enterprise where id_post_enterprise=:id")
    List<PostEnterprise> findAllById(@Param("id") int id);

    @Query(nativeQuery = true, value = "select  * from Case_Study_MD6.post_enterprise where enterprise_id_enterprise=:id")
    List<PostEnterprise> findAllByIdEnterprise(@Param("id") int id);

    //    select * from post_enterprise where id_post_enterprise not in
//            (select post_enterprise_id_post_enterprise from user_apply
//                    where app_user_id = 3)
    @Query(nativeQuery = true, value = " select * from post_enterprise where id_post_enterprise not in " +
            "            (select post_enterprise_id_post_enterprise from user_apply " +
            "                    where app_user_id =:id ) having status_post_enterprise=1 order by priority_post_enterprise DESC ")
    List<PostEnterprise> listPostByOderPriority(@Param("id") int id, Pageable pageable);

    @Query(nativeQuery = true, value = "select  * from Case_Study_MD6.post_enterprise where enterprise_id_enterprise=:id and regime_id_regime=1")
    List<PostEnterprise> listPostVipByEnterprise(@Param("id") int id);

    @Query(nativeQuery = true, value = "select  * from Case_Study_MD6.post_enterprise where enterprise_id_enterprise=:id and regime_id_regime=2")
    List<PostEnterprise> listPostThuongByEnterprise(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update post_enterprise set status_post_enterprise = 0 where  id_post_enterprise=:id ")
    void statusPost(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update post_enterprise set status_post_enterprise = 1 where  id_post_enterprise=:id ")
    void openKeyPost(@Param("id") int id);


    //edit bài viết
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE post_enterprise SET address_main_enterprise =:addressMainEnterprise, describe_post_enterprise =:describePostEnterprise, name_post_enterprise =:namePostEnterprise, salary_big_post_enterprise =:salaryBigPostEnterprise, salary_small_post_enterprise =:salarySmallPostEnterprise, vacancies_post_enterprise =:vacanciesPostEnterprise, field_id_field =:id, form_job_post_enterprise_id_form_job =:formJobPostEnterpriseid WHERE id_post_enterprise =:idPostEnterprise ")
    void editPost(@Param("addressMainEnterprise") String addressMainEnterprise, @Param("describePostEnterprise") String describePostEnterprise, @Param("namePostEnterprise") String namePostEnterprise, @Param("salaryBigPostEnterprise") double salaryBigPostEnterprise, @Param("salarySmallPostEnterprise") double salarySmallPostEnterprise, @Param("vacanciesPostEnterprise") String vacanciesPostEnterprise, @Param("id") int idfield, @Param("formJobPostEnterpriseid") int formJobPostEnterpriseid, @Param("idPostEnterprise") int idPostEnterprise);

    //     số lượng apply theo post
    @Query(nativeQuery = true, value = "select quantity_apply_post from Case_Study_MD6.post_enterprise where  id_post_enterprise=:id ")
    int quantityApplyByIdPost(@Param("id") int id);

    //    update số lượng apply theo post
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update post_enterprise set quantity_apply_post=:quantity where id_post_enterprise=:id ")
    void setQuantityApplyPost(@Param("id") int id, @Param("quantity") int quantity);

    // lấy và chỉnh sửa  điểm đề xuất của bài post theo id
    @Query(nativeQuery = true, value = "select  priority_post_enterprise from Case_Study_MD6.post_enterprise where id_post_enterprise=:id")
    int priorityByIdPost(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update post_enterprise set priority_post_enterprise=:quantity where id_post_enterprise=:id ")
    void setPriorityIdPost(@Param("quantity") int quantity, @Param("id") int id);


    //    Thực hiện xóa bài viết khi hết hạn !
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete  from Case_Study_MD6.post_enterprise where expiration_date_post_enterprise=:date ")
    void deletePostExpired(@Param("date") String date);

    //    lấy tất cả bài đăng của ngày hiện tại
    @Query(nativeQuery = true, value = "select * from Case_Study_MD6.post_enterprise where expiration_date_post_enterprise=:date limit 1")
    PostEnterprise getPostExpired(@Param("date") String date);

    // Tìm kiếm bài viết

    @Query(nativeQuery = true, value = "select * from Case_Study_MD6.post_enterprise where address_main_enterprise LIKE %:address% && field_id_field = :field  ")
    List<PostEnterprise> findByAddressAndField(@Param("address") String address, @Param("field") Long id);

    @Query(nativeQuery = true, value = "select * from Case_Study_MD6.post_enterprise where address_main_enterprise LIKE %:address% && form_job_post_enterprise_id_form_job = :formjob  ")
    List<PostEnterprise> findByAddressAndFormJob(@Param("address") String address, @Param("formjob") int id);

    @Query(nativeQuery = true, value = "select * from Case_Study_MD6.post_enterprise where name_post_enterprise LIKE %:name% && address_main_enterprise LIKE %:address%  ")
    List<PostEnterprise> findPostUserfield(@Param("name") String name, @Param("address") String address);

    @Query(nativeQuery = true, value = "select * from Case_Study_MD6.post_enterprise where id_post_enterprise in " +
            "(select post_enterprise_id_post_enterprise from user_apply " +
            "where app_user_id = :id)")
    List<PostEnterprise> searchPostApplyByUser(@Param("id") int id);

    //     tìm kiếm bài đăng theo địa chỉ và công ty
    @Query(nativeQuery = true, value = "select * from Case_Study_MD6.post_enterprise where address_main_enterprise LIKE %:address% ")
    List<PostEnterprise> findByAddress(@Param("address") String address);

    @Query(nativeQuery = true, value = "select * from Case_Study_MD6.post_enterprise join enterprise on post_enterprise.enterprise_id_enterprise = enterprise.id_enterprise where name_enterprise like %:name%")
    List<PostEnterprise> findByEnterprise(@Param("name") String name);

    @Query(nativeQuery = true, value = "select * from Case_Study_MD6.post_enterprise where form_job_post_enterprise_id_form_job = :id ")
    List<PostEnterprise> findByFormJob(@Param("id") long id);

    @Query(nativeQuery = true, value = "select * from Case_Study_MD6.post_enterprise join enterprise on post_enterprise.enterprise_id_enterprise = enterprise.id_enterprise where enterprise.address_main_enterprise like %:address%")
    List<PostEnterprise> findByCity(@Param("address") String address);

    @Query(nativeQuery = true, value = "select * from Case_Study_MD6.post_enterprise where name_post_enterprise LIKE %:name%")
    List<PostEnterprise> findByNamePost(@Param("name") String name);

//    @Query(nativeQuery = true, value = "select * from case_module_6.post_enterprise where salary_big_post_enterprise between  salary_small_post_enterprise AND  salary_big_post_enterprise ")
//    List<PostEnterprise> findSalary(double salary);

    @Query(nativeQuery = true, value = "select * from Case_Study_MD6.post_enterprise where field_id_field = :idField && form_job_post_enterprise_id_form_job = :idFormJob")
    List<PostEnterprise> findByFieldAndFormJob(@Param("idField") long idfield, @Param("idFormJob") long idformjob);

//    @Query(nativeQuery = true, value = """
//                SELECT * FROM case_study_md6.post_enterprise
//                            WHERE (address_main_enterprise like %:address% OR address_main_enterprise like '') AND
//                            (form_job_post_enterprise_id_form_job = :idFormJob) and
//                            (field_id_field = :idField)
//            """)


//            "SELECT * FROM case_study_md6.post_enterprise" +
//            "WHERE (address_main_enterprise like %address% OR address_main_enterprise like '') AND " +
//            "(form_job_post_enterprise_id_form_job is not null) and (field_id_field is not null)")
//    List<PostEnterprise> findEverything(@Param("address") String address, @Param("idFormJob") long idformjob, @Param("idField") long idfield);

    @Query(value = "SELECT post_enterprise.* FROM post_enterprise " +
            "JOIN enterprise ON post_enterprise.enterprise_id_enterprise = enterprise.id_enterprise " +
            "WHERE (:name = '' or enterprise.name_enterprise like %:name%) AND " +
            "(:address = '' OR post_enterprise.address_main_enterprise like %:address%) AND " +
            "(:idFormJob = -1 OR form_job_post_enterprise_id_form_job = :idFormJob) AND " +
            "(:idField = -1 OR field_id_field = :idField) and id_post_enterprise not in " +
            "(select post_enterprise_id_post_enterprise from user_apply " +
            "where app_user_id =:app_user_id ) having status_post_enterprise=1 order by priority_post_enterprise DESC",
            countQuery = "SELECT COUNT(*) FROM post_enterprise " +
                    "JOIN enterprise ON post_enterprise.enterprise_id_enterprise = enterprise.id_enterprise " +
                    "WHERE (:name = '' or enterprise.name_enterprise like %:name%) AND " +
                    "(:address = '' OR post_enterprise.address_main_enterprise like %:address%) AND " +
                    "(:idFormJob = -1 OR form_job_post_enterprise_id_form_job = :idFormJob) AND " +
                    "(:idField = -1 OR field_id_field = :idField) and id_post_enterprise not in " +
                    "(SELECT post_enterprise_id_post_enterprise from user_apply " +
                    "where app_user_id = :app_user_id) AND status_post_enterprise = 1 ORDER BY priority_post_enterprise DESC", nativeQuery = true)
    Page<PostEnterprise> findPostEnterpriseByCondition(@Param("app_user_id") Long userId, @Param("name") String name, @Param("address") String address, @Param("idFormJob") Long idformjob, @Param("idField") Long idfield, Pageable pageable);

    @Query(nativeQuery = true, value = "select * from case_study_md6.post_enterprise where address_main_enterprise is not null")
    List<PostEnterprise> findAllAddress();

}
