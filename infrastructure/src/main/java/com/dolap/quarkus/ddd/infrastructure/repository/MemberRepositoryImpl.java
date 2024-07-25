package com.dolap.quarkus.ddd.infrastructure.repository;


import com.rodrigof.ddd.domain.member.entity.Member;
import com.rodrigof.ddd.domain.member.repository.MemberRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class MemberRepositoryImpl implements PanacheRepository<Member>, MemberRepository {

    @Override
    public Optional<Member> findMemberById(Long id) {
        return findByIdOptional(id);
    }

    @Override
    public List<Member> findAllMembers() {
        return findAll().list();
    }

    @Override
    @Transactional
    public void save(Member member) {
        persistAndFlush(member);
    }

    @Override
    public Optional<Member> findMemberByUsername(String username) {
        return find("username = ?1", username).stream().findFirst();
    }

    @Override
    @Transactional
    public boolean deleteMemberById(Long id) {
        return deleteById(id);
    }
}
