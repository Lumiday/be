package com.lumiday.jpa.repository;

import com.lumiday.core.enums.AccountDesignType;
import com.lumiday.core.enums.AttendanceType;
import com.lumiday.core.enums.DeceasedDisplayType;
import com.lumiday.core.enums.GalleryType;
import com.lumiday.core.enums.PersonRole;
import com.lumiday.core.enums.PhotoFrameStyle;
import com.lumiday.core.enums.PlaceMapType;
import com.lumiday.core.enums.ThemeColor;
import com.lumiday.core.enums.ThemeFontFamily;
import com.lumiday.core.enums.ThemeFontSize;
import com.lumiday.core.enums.ThemePattern;
import com.lumiday.jpa.TestApplication;
import com.lumiday.jpa.entity.InvitationEntity;
import com.lumiday.jpa.entity.UserEntity;
import com.lumiday.jpa.vo.AccountDetail;
import com.lumiday.jpa.vo.AccountGroup;
import com.lumiday.jpa.vo.AccountInfo;
import com.lumiday.jpa.vo.AttendanceCheck;
import com.lumiday.jpa.vo.BackgroundMusic;
import com.lumiday.jpa.vo.Ending;
import com.lumiday.jpa.vo.Gallery;
import com.lumiday.jpa.vo.IntroLayout;
import com.lumiday.jpa.vo.InvitationMessage;
import com.lumiday.jpa.vo.PersonBaseInfo;
import com.lumiday.jpa.vo.PersonInfo;
import com.lumiday.jpa.vo.ThemeStyle;
import com.lumiday.jpa.vo.TransportationGuide;
import com.lumiday.jpa.vo.WeddingDate;
import com.lumiday.jpa.vo.WeddingPlace;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = TestApplication.class)
@ActiveProfiles("test")
@Transactional
@Rollback
class InvitationRepositoryTest {

    @Autowired
    private InvitationRepository invitationRepository;

    @Test
    void saveAndFind() {
        AccountGroup accountGroup1 = new AccountGroup("groupName1",
                List.of(new AccountDetail("name", "bank", "123123", false)));
        AccountGroup accountGroup2 = new AccountGroup("groupName2",
                List.of(new AccountDetail("name2", "bank2", "234234", false)));
        AccountInfo accountInfo = new AccountInfo("title", "content", AccountDesignType.BASIC, accountGroup1,
                accountGroup2);

        PersonInfo personInfo1 = new PersonInfo(PersonRole.GROOM, "test", "test2", "tsets", false);
        PersonInfo personInfo2 = new PersonInfo(PersonRole.BRIDE, "test", "test2", "tsets", false);
        PersonBaseInfo personBaseInfo = new PersonBaseInfo(DeceasedDisplayType.CHRYSANTHEMUM,
                List.of(personInfo1, personInfo2));

        InvitationEntity invitationEntity = InvitationEntity.builder()
                .accountInfo(accountInfo)
                .attendanceCheck(new AttendanceCheck("title", "content", "button", AttendanceType.ETC))
                .backgroundMusic(new BackgroundMusic("music", false))
                .ending(new Ending("title", "content", "image"))
                .invitationMessage(new InvitationMessage("title", "content"))
                .gallery(new Gallery("name", GalleryType.CHECKERBOARD, false, List.of("image1", "image2", "image3")))
                .introLayout(new IntroLayout("type", PhotoFrameStyle.FRAME, "qweqw"))
                .personBaseInfo(personBaseInfo)
                .theme(new ThemeStyle(ThemeFontFamily.OWNGLYPH, ThemeFontSize.LARGER, ThemeColor.IVORY,
                        ThemePattern.CHECK, false, false))
                .transportationGuide(new TransportationGuide("test", "test"))
                .weddingDate(new WeddingDate(LocalDateTime.now(), false, false))
                .weddingPlace(new WeddingPlace("name", "asdas", "asd", false, PlaceMapType.GOOGLE))
                .user(new UserEntity("email", "passowod"))
                .build();

        invitationRepository.save(invitationEntity);
        Optional<InvitationEntity> findById = invitationRepository.findById(invitationEntity.getId());
        Assertions.assertThat(findById).isPresent();
    }
}