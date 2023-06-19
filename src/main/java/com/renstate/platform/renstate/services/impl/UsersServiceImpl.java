package com.renstate.platform.renstate.services.impl;

import com.renstate.platform.renstate.entities.Users;
import com.renstate.platform.renstate.repositories.IUsersRepository;
import com.renstate.platform.renstate.services.IUsersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = false)
public class UsersServiceImpl implements IUsersService {
    private final IUsersRepository usersRepository;

    public UsersServiceImpl(IUsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Users save(Users users) throws Exception {
        return usersRepository.save(users);
    }

    @Override
    public List<Users> getAll() throws Exception {
        return usersRepository.findAll();
    }

    @Override
    public Optional<Users> getById(Long id) throws Exception {
        return usersRepository.findById(id);
    }

    @Override
    public void delete(Long id) throws Exception {
        usersRepository.deleteById(id);
    }
}
