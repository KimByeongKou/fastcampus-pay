package com.fastcampuspay.remittance.application.service;

import com.fastcampuspay.remittance.adapter.out.persistence.RemittanceRequestJpaEntity;
import com.fastcampuspay.remittance.adapter.out.persistence.RemittanceRequestMapper;
import com.fastcampuspay.remittance.application.port.in.RequestRemittanceCommand;
import com.fastcampuspay.remittance.application.port.out.RequestRemittancePort;
import com.fastcampuspay.remittance.application.port.out.banking.BankingPort;
import com.fastcampuspay.remittance.application.port.out.membership.MembershipPort;
import com.fastcampuspay.remittance.application.port.out.money.MoneyPort;
import com.fastcampuspay.remittance.domain.RemittanceRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

//@RunWith(SpringRunner.class)
//@AutoConfigureMockMvc
@SpringBootTest
public class TestRequestRemittanceService {

    @InjectMocks
    private RequestRemittanceService requestRemittanceService;
    @Mock
    private RequestRemittancePort requestRemittancePort;
    @Mock
    private RemittanceRequestMapper mapper;
    @Mock
    private BankingPort bankingPort;
    @Mock
    private MembershipPort membershipPort;
    @Mock
    private MoneyPort moneyPort;



    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        /**
         * @NOTE
         * private final 필드의 경우, setter 를 통해 주입할 수 없기 때문에
         * Reflection or Constructor 를 통해 주입해야 한다.
         */
        requestRemittanceService = new RequestRemittanceService(requestRemittancePort, mapper, membershipPort, moneyPort, bankingPort);
    }

    private static Stream<RequestRemittanceCommand> provideRequestRemittanceCommand() {
        return Stream.of(
                RequestRemittanceCommand.builder()
                        .fromMembershipId("5")
                        .toMembershipId("4")
                        .toBankName("bank22")
                        .remittanceType(0)
                        .toBankAccountNumber("1234")
                        .amount(155500)
                        .build()
        );
    }
    @ParameterizedTest
    @MethodSource("provideRequestRemittanceCommand")
    public void testTestMethod(RequestRemittanceCommand testCommand){
        RemittanceRequestJpaEntity tt = new RemittanceRequestJpaEntity(
                1L,
                "test_from_membership_id",
                "test_to_membership_id",
                "test_to_bank_name",
                "123-456-789",
                0,
                10000,
                "success"
        );

        if (testCommand.getFromMembershipId().equals("2")) {
            when(requestRemittancePort.createRemittanceRequestHistory(testCommand))
                    .thenReturn(null);
        } else {
            when(requestRemittancePort.createRemittanceRequestHistory(testCommand))
                    .thenReturn(tt);
            when(mapper.mapToDomainEntity(tt)).thenReturn(RemittanceRequest.generateRemittanceRequest(
                    new RemittanceRequest.RemittanceRequestId("test_id"),
                    new RemittanceRequest.RemittanceFromMembershipId("test_from_membership_id"),
                    new RemittanceRequest.ToBankName("test_to_membership_id"),
                    new RemittanceRequest.ToBankAccountNumber("123-456-789"),
                    new RemittanceRequest.RemittanceType(0),
                    new RemittanceRequest.Amount(10000),
                    new RemittanceRequest.RemittanceStatus("success")));
        }


        RemittanceRequest want = RemittanceRequest.generateRemittanceRequest(
                new RemittanceRequest.RemittanceRequestId("test_id"),
                new RemittanceRequest.RemittanceFromMembershipId("test_from_membership_id"),
                new RemittanceRequest.ToBankName("test_to_membership_id"),
                new RemittanceRequest.ToBankAccountNumber("123-456-789"),
                new RemittanceRequest.RemittanceType(0),
                new RemittanceRequest.Amount(10000),
                new RemittanceRequest.RemittanceStatus("success")
        );

        RemittanceRequest got = requestRemittanceService.testMethod(testCommand);

        verify(requestRemittancePort, times(1)).createRemittanceRequestHistory(testCommand);
        verify(mapper, times(1)).mapToDomainEntity(tt);
        assertEquals(want, got);
    }

}
