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
        AccountGroup accountGroup1 = AccountGroup.of("groupName1",
                List.of(AccountDetail.of("name", "bank", "123123", false)));
        AccountGroup accountGroup2 = AccountGroup.of("groupName2",
                List.of(AccountDetail.of("name2", "bank2", "234234", false)));
        AccountInfo accountInfo = AccountInfo.of("title", "content", AccountDesignType.BASIC, accountGroup1,
                accountGroup2);

        PersonInfo personInfo1 = PersonInfo.of(PersonRole.GROOM, "test", "test2", "tsets", false);
        PersonInfo personInfo2 = PersonInfo.of(PersonRole.BRIDE, "test", "test2", "tsets", false);
        PersonBaseInfo personBaseInfo = PersonBaseInfo.of(DeceasedDisplayType.CHRYSANTHEMUM,
                List.of(personInfo1, personInfo2));

        InvitationEntity invitationEntity = InvitationEntity.builder()
                .accountInfo(accountInfo)
                .attendanceCheck(AttendanceCheck.of("title", "content", "button", AttendanceType.ETC))
                .backgroundMusic(BackgroundMusic.of("music", false))
                .ending(Ending.of("title", "content", "image"))
                .invitationMessage(InvitationMessage.of("title", "content"))
                .gallery(Gallery.of("name", GalleryType.CHECKERBOARD, false, List.of("image1", "image2", "image3")))
                .introLayout(IntroLayout.of("type", PhotoFrameStyle.FRAME, "qweqw"))
                .personBaseInfo(personBaseInfo)
                .theme(ThemeStyle.of(ThemeFontFamily.OWNGLYPH, ThemeFontSize.LARGER, ThemeColor.IVORY,
                        ThemePattern.CHECK, false, false))
                .transportationGuide(TransportationGuide.of("test", "test"))
                .weddingDate(WeddingDate.of(LocalDateTime.now(), false, false))
                .weddingPlace(WeddingPlace.of("name", "asdas", "asd", false, PlaceMapType.GOOGLE))
                .user(UserEntity.of("email", "passowod"))
                .build();

        invitationRepository.save(invitationEntity);
        Optional<InvitationEntity> findById = invitationRepository.findById(invitationEntity.getId());
        Assertions.assertThat(findById).isPresent();
    }
}