package ua.happycash.service.creaditCard;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.happycash.database.entity.CreditCard;
import ua.happycash.database.entity.Wallet;
import ua.happycash.database.repository.CreditCardRepository;
import ua.happycash.dto.creditCard.CreditCardCreateEditDto;
import ua.happycash.dto.creditCard.CreditCardReadDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreditCardServiceImpl implements CreditCardService{

    private final CreditCardRepository creditCardRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<CreditCardReadDto> getById(String id) {
        return creditCardRepository.findById(id).map(creditCard -> modelMapper.map(creditCard, CreditCardReadDto.class));
    }

    @Override
    public List<CreditCardReadDto> getAllByWallet(Wallet wallet) {
        return creditCardRepository.findAllByWallet(wallet)
                .stream().map(creditCard -> modelMapper.map(creditCard, CreditCardReadDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Optional<CreditCardReadDto> create(CreditCardCreateEditDto creditCardCreateEditDto) {
        return Optional.of(creditCardCreateEditDto)
                .map(creditCard -> modelMapper.map(creditCardCreateEditDto, CreditCard.class))
                .map(creditCardRepository::save)
                .map(creditCard -> modelMapper.map(creditCard, CreditCardReadDto.class));
    }

    @Transactional
    public Optional<CreditCardReadDto> update(String id, CreditCardCreateEditDto scheduleDto) {
        return creditCardRepository.findById(id)
                .map(entity -> {
                    CreditCard mappedEntity = modelMapper.map(scheduleDto, CreditCard.class);
                    mappedEntity.setId(entity.getId());
                    return mappedEntity;
                })
                .map(creditCardRepository::save)
                .map(schedule -> modelMapper.map(schedule, CreditCardReadDto.class));
    }

    @Transactional
    public boolean delete(String id) {
        return creditCardRepository.findById(id)
                .map(entity -> {
                    creditCardRepository.deleteById(id);
                    return true;
                })
                .orElse(false);
    }

}
